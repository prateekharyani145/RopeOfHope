var Item_arr = new Array("Pencil", "Drawing", "Colour", "Pen", "Copy", "Eraser", "Sharpener", "StudyTable", "Scale", "Chalk", "Duster", "Board");

var t = new Array();
t[0]="";
t[1]="Colour | Plain | Other ";
t[2]="Book | Sheet |Other ";
t[3]="Water | Sketch | Crayons | Other ";
t[4]="Ball | Gel | Ink | Other";
t[5]="Rough | Fair | Other";
t[6]=" Default ";
t[7]=" Default ";
t[8]=" Default ";
t[9]=" Small | Large | Other";
t[10]=" Default ";
t[11]=" Default ";
t[12]=" Black | White";

function print_item(item_id){
	// given the id of the <select> tag as function argument, it inserts <option> tags
	var option_str = document.getElementById(item_id);
	option_str.length=0;
	option_str.options[0] = new Option('Select Item','');
	option_str.selectedIndex = 0;
	for (var i=0; i<Item_arr.length; i++) {
		option_str.options[option_str.length] = new Option(Item_arr[i],Item_arr[i]);
	}
}

function print_type(type_id, type_index)
{
	var option_str = document.getElementById(type_id);
	option_str.length=0;
	option_str.options[0] = new Option('Select Type','');
	option_str.selectedIndex = 0;
	var type_arr = t[type_index].split("|");
	for (var i=0; i<type_arr.length; i++) {
		option_str.options[option_str.length] = new Option(type_arr[i],type_arr[i]);
	}
}

function up(max) {
    document.getElementById("myNumber").value = parseInt(document.getElementById("myNumber").value) + 1;
    if (document.getElementById("myNumber").value >= parseInt(max)) {
        document.getElementById("myNumber").value = max;
    }
}
function down(min) {
    document.getElementById("myNumber").value = parseInt(document.getElementById("myNumber").value) - 1;
    if (document.getElementById("myNumber").value <= parseInt(min)) {
        document.getElementById("myNumber").value = min;
    }
}

//Signup Volunteer Validation


   