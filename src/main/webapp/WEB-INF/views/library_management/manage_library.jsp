<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div  class="card rounded-0 transparent_card">
	<div  class="card-body">
		<div class="form-group row">
		<div class="col-sm-12">
		<button class="btn btn-primary float-right mb-2" onclick="modalstore()"> Store Book</button>
		</div>
		<div class="col-sm-12">
		<table id="manage_lib" class="table-bordered">
		<thead class="headertab">
		<tr>
		<th>No</th>
<!-- 		<th>Cover</th> -->
		<th>Book Name</th>
		<th>Genre</th>
		<th>Author</th>
		<th>Action</th>
		</tr>
		</thead>
		<tbody>
		</tbody>
		</table>
		</div>
		</div>
	</div>
</div>
<script>
$(document).ready(function() {
	console.log('${username}')
	manage_Book()
	})
</script>