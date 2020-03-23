function AjouterCour() {
    var cboCours = document.getElementById("idCour");
    var indexSelection = cboCours.selectedIndex;
    var id = cboCours.options[indexSelection].value;
    document.getElementById("idCourID").value = id;
}
