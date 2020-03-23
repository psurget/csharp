using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using ProjectLayout.Models;
using System.Collections.Specialized;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Session;
using Newtonsoft.Json;

namespace ProjectLayout.Controllers
{
    public class HomeController : Controller
    {
        DBStudealContext Context = new DBStudealContext();
        public const string SessionKeyID = "_ID";
        public const string SessionKeyFName = "_FName";
        public const string SessionKeyLName = "_LName";
        public const string SessionKeyUName = "_UName";
        public const string SessionKeyIsTutot = "_IsTutor";

        public HomeController(DBStudealContext _context)
        {
            this.Context = _context;
        }
        [RequireHttps]
        public void GetSession(int ID,string FName, string LName, string UName,Int32 IsTutor)
        {
            // Requires: using Microsoft.AspNetCore.Http;
           // if (string.IsNullOrEmpty(HttpContext.Session.GetString(SessionKeyFName)))
            {
                HttpContext.Session.SetInt32(SessionKeyID, ID);
                HttpContext.Session.SetString(SessionKeyFName, FName);
                HttpContext.Session.SetString(SessionKeyLName, LName);
                HttpContext.Session.SetString(SessionKeyLName, LName);
                HttpContext.Session.SetInt32(SessionKeyIsTutot, IsTutor);
            }
        }

    
        public IActionResult Index()
        {
            ViewBag.Message = ViewData["Message"];
            return View();
        }

        public IActionResult About()
        {
            ViewData["Message"] = "Your application description page.";

            return View();
        }
        [RequireHttps]
        public IActionResult Contact()
        {
            ViewData["Message"] = "Your contact page.";
            ViewBag.FName = HttpContext.Session.GetString(SessionKeyFName);
            ViewBag.LName = HttpContext.Session.GetString(SessionKeyLName);
            ViewBag.ID = HttpContext.Session.GetInt32(SessionKeyID);
            return View();
        }
        [RequireHttps]
        public IActionResult Inscription()
        {
            ViewBag.Message = ViewData["Message"];

            return View();
        }
        [RequireHttps]
        public IActionResult TraitementInscription(string LastName, string FirstName,string UserName,string Pass, string ConfirmPass, int IsTotor)
        {
            ViewData["Message"] = "coucou";
            if (LastName == null || FirstName == null || UserName == null|| Pass == null || ConfirmPass == null)
            {
                ViewData["Message"] = "Veuillez remplir tout les champs";
                return View("Inscription");
            }
            if(Pass != ConfirmPass)
            {

                ViewData["Message"] = "La confirmation de mot de passe est incorrecte";
                return View("Inscription");
            }
            Member Membre = new Member();
            Membre.LastName = LastName;
            Membre.FirstName = FirstName;
            Membre.UserName = UserName;
            Membre.Password = Pass;
            Membre.IsTutor = IsTotor;
            Context.Add(Membre);
            Context.SaveChanges();
            return View();        
        }
        [RequireHttps]
        public IActionResult Connecter(string UserName, string Password)
        {
          if(UserName == null || Password == null)
            {
                ViewData["Message"] = "Veuillez saisir le nom d utilisateur et le mot de passe! ";
                return View("Index");
                
            }
          var req = from m in Context.Member
                    where m.UserName.Equals(UserName) && m.Password.Equals(Password)
                     select m;
            if(req.Count() == 0)
            {
                ViewData["Message"] = "Utilisateur ou mot de passe incorrect!";
                return View("Index");
            }
            
            List<Member> membres = req.ToList();
            int ID = membres[0].Id;
            string LName = membres[0].FirstName;
            string FName = membres[0].LastName;
            string UName = membres[0].UserName;
            Int32 IsTutor = (Int32) membres[0].IsTutor;

            GetSession(ID,LName,FName,UName,IsTutor);
            if(IsTutor == 1)
            {
                return RedirectToAction("Index", "Membre");
            }

            return RedirectToAction("Contact");
        }
        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
