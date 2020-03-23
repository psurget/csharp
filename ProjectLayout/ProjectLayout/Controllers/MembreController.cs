using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ProjectLayout.Models;

namespace ProjectLayout.Controllers
{
    public class MembreController : Controller
    {
        DBStudealContext Context = new DBStudealContext();
        public const string SessionKeyID = "_ID";
        public const string SessionKeyFName = "_FName";
        public const string SessionKeyLName = "_LName";
        public const string SessionKeyUName = "_UName";
        public const string SessionKeyIsTutot = "_IsTutor";
        public MembreController(DBStudealContext _context)
        {
            this.Context = _context;
        }
        // GET: Membre
        [RequireHttps]
        public ActionResult Index()
        {
            ViewData["Message"] = "Your contact page.";
            //int TutorID = (int)HttpContext.Session.GetInt32(SessionKeyID);
            ViewBag.FName = HttpContext.Session.GetString(SessionKeyFName);
            ViewBag.LName = HttpContext.Session.GetString(SessionKeyLName);
            
            return View();
        }
        [RequireHttps]
        public ActionResult Index2()
        {
            ViewData["Message"] = "Your contact page.";
            int TutorID = (int)HttpContext.Session.GetInt32(SessionKeyID);
            ViewBag.FName = HttpContext.Session.GetString(SessionKeyFName);
            ViewBag.LName = HttpContext.Session.GetString(SessionKeyLName);
            var req = from c in Context.Tutoring
                      where c.TutorId == TutorID
                      select c;
            List<Tutoring> cours = req.ToList();
            List<TimeSlot> times = new List<TimeSlot>();
            foreach (var c in cours)
            {
                var req2 = from t in Context.TimeSlot
                           where t.TutoringId == c.TutoringId
                           select t;
                times.Concat(req2.ToList());
            }
            return View(cours);
        }

        // GET: Membre/Details/5
        public ActionResult Details(int CourID)
        {
            var req = from t in Context.TimeSlot
                      where t.TutoringId == CourID
                      select t;
            List<TimeSlot> times = req.ToList();
            return View(times);
        }
        public ActionResult AjoutCour()
        {
            return View();
        }

        // GET: Membre/Create
        public ActionResult TraitementAjoutCour(string Sujet)
        {
            ViewData["Message"] = "coucou";
            if (Sujet == null)
            {
                ViewBag.Message = "Veuillez remplir le champ";
                return View("AjoutCour","Membre");
            }
            
            Tutoring Cour = new Tutoring();
            Cour.Subject = Sujet;
            Int32 TutorID = (Int32)HttpContext.Session.GetInt32(SessionKeyID);
            Cour.TutorId = TutorID;
             Cour.CreationDate = DateTime.Now;
             Context.Add(Cour);
             Context.SaveChanges();
             
            ViewBag.Message = "Tutor ID est    "+TutorID;
            
            return View("AjoutCour","Membre");
        }


        [RequireHttps]
        public ActionResult AjoutDisponible()
        {
            
            ViewBag.Message = ViewData["Message"];
            int id= (int)HttpContext.Session.GetInt32(SessionKeyID);
            var req = from cour in Context.Tutoring
                      where cour.TutorId == id
                      orderby cour.TutoringId
                      select cour;
            List<Tutoring> cours = req.ToList();   
            return View(cours);  
        }
        public ActionResult AjoutDisponible2(string Error)
        {

            ViewBag.Message = Error;
            int id = (int)HttpContext.Session.GetInt32(SessionKeyID);
            var req = from cour in Context.Tutoring
                      where cour.TutorId == id
                      orderby cour.TutoringId
                      select cour;
            List<Tutoring> cours = req.ToList();
            return View(cours);
        }
        [RequireHttps]
        public ActionResult TraitementDisponible(string Jour,string HeureDebut,string HeureFin,int TutoringID)
        {
            if(Jour ==null || HeureDebut == null || HeureFin == null || TutoringID == 0)
            {
              
                return RedirectToAction("AjoutDisponible2", new {error = "Veuillez saisir tout les champs" });
            }
            TimeSlot time = new TimeSlot();
            time.Day = Jour;
            time.StartTime = HeureDebut;
            time.EndTime = HeureFin;
            time.TutoringId = TutoringID;
            Context.Add(time);
            Context.SaveChanges();

            return View("Index");
        }

        // GET: Membre/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Membre/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: Membre/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Membre/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}