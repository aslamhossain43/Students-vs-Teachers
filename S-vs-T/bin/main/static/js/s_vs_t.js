
var table=$('#viewallcouching');

if(table.length){

	var jsonUrl=jsonurl;
	

	 table.DataTable({
  lengthMenu:[[30,73,-1],['30 files','73 files','All']],
  pageLength:30,
  ajax:{
	  url:jsonUrl,
	  dataSrc : ''
	 
	  
  },
  columns : [
	  
	 
		 {
			data:'iCode',
			mRender:function(data){
				var str='';
				
				str+='<img src="images/'+data+'.jpg" id="viewAllCouchingImg" >';
				return str;
				
				
				
			}
		
		
	  },
	  {
		  
		  data:'couchingName',
		 
	  }
	  ,
	  {
		  data:'districtName'
		 
		  
		  
	  },
	  {
		  data:'jobType'
		 
	  },
	  {
		  data:'institutionDepartment'
		 
	  },
	  {
		  data:'classes'
		 
	  },
	  {
		  data:'address'
		 
	  },
	 
	  {
		  data:'contact'
		 
	  }
	  ,
	  {
		  
		  data:'lastModifiedDate'
		 
		 
	  }
	  ,
	  {
		  data:'id',
		  mRender:function(data){
			  				
			  var str='';
					
		
					if (userRole=='ADMIN') {
						
			  str+='<a href="/updateJobType?id='+data+'" id="editTrauncate" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>';
                
						
					str+='<a href="/delete?id='+data+'" id="editTrauncate" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a>';
					return str;
					}if (userRole=='USER') {
						  str+='<a href="/showUpdateWordByUser?id='+data+'" id="editTrauncate" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>';
				             
						return str;
					}
											
			  return str;
			
			  
		  }
		 
	  }
	 
  ]
	
	
	
	
});
} 
























