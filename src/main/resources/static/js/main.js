//href="https://wa.me/+50372682989/?text=Texto"
function ShowSelected()
{
/* Para obtener el valor */
var cod = document.getElementById("producto").value;
alert(cod);
 
/* Para obtener el texto */
var combo = document.getElementById("producto");
var selected = combo.options[combo.selectedIndex].text;
alert(selected);
}
const contactUs = () =>{
    let val1 = document.getElementById("whats").value;
    location.href='https://wa.me/+50360605555/?text='+val1;
}

function obtenerIds(id) {

    let val1 = id
    location.href = './product?id=' + val1;
    
};
function track(id) {
	let cod= document.getElementById("demo2").value;
	let cod2= document.getElementById("demo2").text;

	location.href = './orderDetails?id='+ id;
    
};

function deleteCarrito(){
	 location.href = './eliminarCarrito';
}

function eliminar(id,id2) {
    let val1 = id
    let cod = document.getElementById("material").value;
    alert(id2)
    let cod2 = document.getElementById("material").text;
    
    location.href = './eliminarDelCarrito?id=' + val1 + "&material=" + id2;

};

function obtenerIdsC(id) {
    let val1 = id
    let cod = document.getElementById("tipomaterial").value;
   
    var combo = document.getElementById("tipomaterial");
    let selected = combo.options[combo.selectedIndex].text;
    
    location.href = './Shop?id=' + val1  + "&material="+ cod;
};

$(window).load(function() {
	  $('.flexslider2').flexslider({
	    animation: "slide"
	  });
	});

(function () {

    var indexSlider = function () {

        $('#flexcontainer .flexslider .slides > li').css('height', $(window).height());
        $(window).resize(function () {
            $('#flexcontainer .flexslider .slides > li').css('height', $(window).height());
        });

        $(window).load(function () {
            $('.flexslider').flexslider();
        });

    };

    $(function () {
        indexSlider();

    });

}());
