const datosTabla = (tabla, mensaje, rutaBtn, extra) => {
    $(document).ready(function () {
        var table = $('#tabla').DataTable({
            "ordering": false,
            "processing": true,
            "serverSide": true,
            "ajax": tabla,
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.19/i18n/Spanish.json"
            },
            "pageLength": 5,
            "columnDefs": [{
                "targets": 0,
                "data": null,
                "searchable": false,
                "defaultContent": "<button class='btn btn-info' title='" + mensaje + "' id='i'><i class='fa fa-pencil-alt'></i></button>"
            }]
        });
        $('#tabla tbody').on('click', '#i', function () {
            var data = table.row($(this).parents('tr')).data();
            location.href = './' + rutaBtn + '?id=' + data[0] + extra;
        });
    });
}

const mostrarTabla = (tabla) => {
    var ruta;
    var mensaje;
    var rutaBtn;
    var extra;

    switch (tabla) {
        case 1:
            ruta = "/CargarProductos";
            mensaje = "Editar producto";
            rutaBtn = "./adminEditarProducto";
            extra = "";
            break;

        case 2:
            ruta = "/CargarProductos";
            mensaje = "Eliminar producto";
            rutaBtn = "./adminEliminarProducto";
            extra = "";
            break;
        case 3:
            ruta = "/adminCargarMaterial";
            mensaje = "Editar material";
            rutaBtn = "./adminEditarMaterial";
            extra = "";
            break;
        case 4:
            ruta = "/adminCargarTipoProducto";
            mensaje = "Editar tipo producto";
            rutaBtn = "./adminEditarTipoProducto";
            extra = "";
            break;
    }

    datosTabla(ruta, mensaje, rutaBtn, extra);
}
