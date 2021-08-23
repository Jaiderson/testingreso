function eliminarAction(id, urlAction, urlRef){
	Swal.fire({
	    title: "Seguro de elminar el registro?",
	    type: "question",
	    confirmButtonText: "Confirmar",   // Modificar la información del texto del botón de confirmación
	    showCancelButton: true,           // Botón de inicio de cancelación
	    cancelButtonText: "Cancelar"      // Modificar la información del texto del botón cancelar
	}).then(function (result) {
	    if (result.value) {
	       $.ajax({ url: urlAction + id,
				   success: function(res){
						console.log(res);
				    }
			});
            Swal.fire({
				title: "Registro eliminado correctamente.",
	            type: "success"
	        }).then((ok) => {
				if(ok){
					location.href = urlRef;
				}
			});
	    }
	    else{
			Swal.fire({
				title: "¡El registro no fue eliminado!",
				type: "warning"
			});
		}
	});
}

function pagarAction(id){
				Swal.fire({
				title: "¡El registro "+id+" no fue eliminado!",
				type: "warning"
			});
	
	
}


