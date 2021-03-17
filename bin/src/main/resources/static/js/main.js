function obtenerIds(id) {
		
			let val1 = id
			location.href = './product?id=' + val1;
			alert("asasas")
		
	};
	
function obtenerIdsC(id){
	let val1 = id
	location.href = './Shop?id=' + val1;
	alert("simon" + id)
};

(function (){

    var indexSlider = function(){
        
        $('#flexcontainer .flexslider .slides > li').css('height', $(window).height());	
        $(window).resize(function(){
            $('#flexcontainer .flexslider .slides > li').css('height', $(window).height());	
        });

        $(window).load(function () {
            $('.flexslider').flexslider();
        });

    };

    $(function(){
        indexSlider();

    });

}());

const datosTabla = (tabla, mensaje, rutaBtn, extra)=>{
    $(document).ready(function(){
		var table = $('#tabla').DataTable( {
			"ordering": false,
	        "processing": true,
	        "serverSide": true,
	        "ajax": tabla,
	        "language": {
	            "url": "//cdn.datatables.net/plug-ins/1.10.19/i18n/Spanish.json"
	        },
	        "pageLength": 5,
	        "columnDefs": [ {
	            "targets": 0,
	            "data": null,
	            "searchable": false,
	            "defaultContent": "<button class='btn btn-info' title='"+mensaje+"' id='i'><i class='fa fa-pencil-alt'></i></button>"
	        }]
	    });
		$('#tabla tbody').on( 'click', '#i', function () {
	        var data = table.row( $(this).parents('tr') ).data();
	        	location.href = './'+rutaBtn+'?id=' + data[0] + extra;
	    } );
	});
}

const mostrarTabla = (tabla) => {
    var ruta;
    var mensaje;
    var rutaBtn;
    var extra;

    switch(tabla){
        case 1: 
            ruta="/cargarProductos";
            mensaje="Editar producto";
            rutaBtn="./editarProducto";
            extra="";
            break;

        case 2:
            ruta="/cargarProductos";
            mensaje="Eliminar producto";
            rutaBtn="./eliminarProducto";
            extra="";
            break;
        case 3:
            ruta="/cargarMaterial";
            mensaje="Editar material";
            rutaBtn="./editarMaterial";
            extra="";
            break;
        case 4:
            ruta="/cargarTipoProducto";
            mensaje="Editar tipo producto";
            rutaBtn="./editarTipoProducto";
            extra="";
            break;
    }

    datosTabla(ruta,mensaje,rutaBtn,extra);
}
