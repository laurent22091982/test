 $(document).ready(function() {
	   $(".datepicker").datepicker({
	      dateFormat: 'dd/mm/yy',
	      changeMonth: true,
	      changeYear: true,
	      firstDay : 1,
	      monthNames: ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'],
	      monthNamesShort: ['Janv.', 'Févr.', 'Mars', 'Avril', 'Mai', 'Juin', 'Juil.', 'Août', 'Sept.', 'Oct.', 'Nov.', 'Déc.'],
	      dayNames: ['Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'],
	      dayNamesShort: ['Dim.', 'Lun.', 'Mar.', 'Mer.', 'Jeu.', 'Ven.', 'Sam.'],
	      dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
	   }) .datepicker.setDefaults( $.datepicker.regional[ "fr" ] );
	   
	});