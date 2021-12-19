<!-- modal success edit -->
<div class="modal fade" id="edit_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header exim_color">
                <h3 class="modal-title" id="exampleModalLabel">Edit Book</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
            <div class="form-group row">
            <div class="col-sm-4">
            <h5>Book Name</h5>
            </div>
            <div class="col-sm-8 ">
            <input type="text" class="form-control" id="book_name">
            </div>
            
            <div class="col-sm-4 pt-2">
            <h5>Genre</h5>
            </div>
            <div class="col-sm-8 pt-2">
           <select class="form-control" id="book_genre">
           <option value="1">Adventure</option>
           <option value="5">Comedy</option>
           <option value="8">Documentary</option>
           <option value="7">Gore</option>
           <option value="2">Horror</option>
           <option value="3">Romance</option>
           <option value="6">Sci-fi</option>
           <option value="9">Slice of life</option>
           <option value="4">Thriller</option>
           </select>
            </div>
            <div class="col-sm-4 pt-2">
            <h5>Author</h5>
            </div>
            <div class="col-sm-8 pt-2">
             <input type="text" class="form-control" id="book_author">
              <input type="text" class="form-control d-none" id="book_id">
            </div>
            </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" onclick="save()">Save</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="store_book" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header exim_color">
                <h3 class="modal-title" id="exampleModalLabel">Store</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
              <div class="form-group row">
            <div class="col-sm-4">
            <h5>Book Name</h5>
            </div>
            <div class="col-sm-8 ">
            <input type="text" class="form-control" id="book_name_store">
            </div>
            
            <div class="col-sm-4 pt-2">
            <h5>Genre</h5>
            </div>
            <div class="col-sm-8 pt-2">
           <select class="form-control" id="book_genre_store">
           <option value="1">Adventure</option>
           <option value="5">Comedy</option>
           <option value="8">Documentary</option>
           <option value="7">Gore</option>
           <option value="2">Horror</option>
           <option value="3">Romance</option>
           <option value="6">Sci-fi</option>
           <option value="9">Slice of life</option>
           <option value="4">Thriller</option>
           </select>
            </div>
            <div class="col-sm-4 pt-2">
            <h5>Author</h5>
            </div>
            <div class="col-sm-8 pt-2">
             <input type="text" class="form-control" id="book_author_store">
              <input type="text" class="form-control d-none" id="book_id">
            </div>
            </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" onclick="store()">Save</button>
            </div>
        </div>
    </div>
</div>

<!-- modal success va pending -->
<!-- <div class="modal fade" id="success_pending" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"> -->
<!--     <div class="modal-dialog" role="document"> -->
<!--         <div class="modal-content"> -->
<!--             <div class="modal-header exim_color"> -->
<!--                 <h3 class="modal-title" id="exampleModalLabel">Mapping</h3> -->
<!--                 <button type="button" class="close" data-dismiss="modal" aria-label="Close"> -->
<!--                     <span aria-hidden="true">&times;</span> -->
<!--                 </button> -->
<!--             </div> -->
<!--             <div class="modal-body"> -->
<!--                 <h5 class="msg-success-pending"></h5> -->
<!--             </div> -->
<!--             <div class="modal-footer"> -->
<!--                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> -->
<!--             </div> -->
<!--         </div> -->
<!--     </div> -->
<!-- </div> -->