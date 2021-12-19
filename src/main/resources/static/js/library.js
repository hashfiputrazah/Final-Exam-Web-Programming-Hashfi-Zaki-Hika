function getBook() {
	  $.ajax({
	        url: "/e_library/get_Book",
	        type: "GET",
	        success: function(res) {
	        	let data = JSON.parse(res)
	        	console.log(data,"res")
	        	let TD = '';
	        	for (var i = 0; i < data.length; i++) {
					TD +='<tr>';
					TD +='<td>';
					TD +='</td>';
//					TD +='<td>';
//					TD +=''+data[i].book_image+'';
//					TD +='</td>';
					TD +='<td>';
					TD +=''+data[i].book_name+'';
					TD +='</td>';
					TD +='<td>';
					TD +=''+data[i].genre_name+'';
					TD +='</td>';
					TD +='<td>';
					TD +=''+data[i].book_author+'';
					TD +='</td>';
//					TD +='<td>';
//					TD +=''+data[i].id_book+'';
//					TD +='</td>';
					TD +='</tr>';
				}
	        	$("#list_lib tbody").append(TD)
	        	let table = $("#list_lib").DataTable()
	        	
	        	  table.on('order.dt search.dt', function() {
	        	        table.column(0, {
	        	            search: 'applied',
	        	            order: 'applied'
	        	        }).nodes().each(function(cell, i) {
	        	            let a = i + 1;
	        	            cell.innerHTML = "<input class='d-none' value=" + a + "><a>" + a + "</a>";
	        	        });
	        	    }).draw();
	        }
	  })
}
function manage_Book() {
   	let table = $("#manage_lib").DataTable();
   	table.destroy()
   	$("#manage_lib tbody").empty()
	  $.ajax({
	        url: "/e_library/get_Book",
	        type: "GET",
	        success: function(res) {
	        	let data = JSON.parse(res)
	        	console.log(data,"res")
	        	let TD = '';
	        	for (var i = 0; i < data.length; i++) {
					TD +='<tr>';
					TD +='<td>';
					TD +='</td>';
//					TD +='<td>';
//					TD +=''+data[i].book_image+'';
//					TD +='</td>';
					TD +='<td>';
					TD +=''+data[i].book_name+'';
					TD +='</td>';
					TD +='<td>';
					TD +=''+data[i].genre_name+'';
					TD +='</td>';
					TD +='<td>';
					TD +=''+data[i].book_author+'';
					TD +='</td>';
					TD +='<td class="text-center">';
					TD +='<button class="btn btn-primary mr-2" onclick="Edit(\'' + data[i].id_book + '\',\'' + data[i].book_name + '\',\'' + data[i].book_genre + '\',\'' + data[i].book_author + '\')">Edit</button>';
					TD +='<button class="btn btn-warning " onclick="Deletes(\'' + data[i].id_book + '\')"> Delete </button>';
					TD +='</td>';
					TD +='</tr>';
				}
	        	$("#manage_lib tbody").append(TD)
	        	let table = $("#manage_lib").DataTable()
	        	
	        	  table.on('order.dt search.dt', function() {
	        	        table.column(0, {
	        	            search: 'applied',
	        	            order: 'applied'
	        	        }).nodes().each(function(cell, i) {
	        	            let a = i + 1;
	        	            cell.innerHTML = "<input class='d-none' value=" + a + "><a>" + a + "</a>";
	        	        });
	        	    }).draw();
	        }
	  })
}

function Edit(id,bk_name,bk_genre,bk_author) {
	console.log("id:",id)
//	variable
	$("#book_id").val(id)
	$("#book_name").val(bk_name)
	$("#book_genre").val(bk_genre)
	$("#book_author").val(bk_author)
	$("#edit_modal").modal("show")
}
function Deletes(id) {
	console.log("id",id)
    $.ajax({
    	  url: "manage_library/delete_Book",
    	  type: "POST",
    	  data: {
    		  data : id
    	  },
    	  success: function(res) {
    		  manage_Book()
        Swal.fire({
                title: "Delete Success",
                html: "<h5>" + res + "</h5>",
                icon: "success"
            });
    	  }
    	})	
}
function save() {
	let obj = {
			id_book : $("#book_id").val(),
			book_name : $("#book_name").val(),
			book_genre : $("#book_genre").val(),
			book_author : $("#book_author").val()
	}
    $.ajax({
  url: "manage_library/update_Book",
  type: "POST",
  data: {
	  data : JSON.stringify(obj)
  },
  success: function(res) {
	  manage_Book()
  Swal.fire({
                title: "Update book success",
                html: "<h5>" + res + "</h5>",
                icon: "success"
            });
             $("#edit_modal").modal("hide")
  }
})	
}
function modalstore(){
	$("#store_book").modal("show")
}
function store(){
	let obj = {
		book_name : $("#book_name_store").val(),
		book_genre : $("#book_genre_store").val(),
		book_author : $("#book_author_store").val()
	}
    $.ajax({
  url: "manage_library/insert_Book",
  type: "POST",
  data: {
	  data : JSON.stringify(obj)
  },
  success: function(res) {
	  manage_Book()
 	 Swal.fire({
                title: "Store book success",
                html: "<h5>" + res + "</h5>",
                icon: "success"
            });
            $("#store_book").modal("hide")
  }
})	
	
}