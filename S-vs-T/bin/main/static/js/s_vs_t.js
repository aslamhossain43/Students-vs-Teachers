
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
		  
		  data:'id',
		  mRender:function(data){
			  				
			  var str='';
			
						
			  str+='<a href="/singleViewForCouching?id='+data+'" id="gmapjs" class="btn btn-primary">View Single</a>';
                	return str;
					
		  }
		  
	  }
	  ,
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
		  
		  data:'id',
		  mRender:function(data){
			  				
			  var str='';
			
						
			  str+='<a href="/map?id='+data+'" id="gmapjs" class="btn btn-primary"><span class="glyphicon glyphicon-map-marker ">Google Maps</span></a>';
                	return str;
					
		  }
		  
	  }
	  ,
	 
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
						
			  str+='<a href="/updateCouchingCenterByAdmin?id='+data+'" id="editTrauncate" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>';
                
						
					str+='<a href="/deleteCouchingByAdmin?id='+data+'" id="editTrauncate" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a>';
					return str;
					}if (userRole=='USER') {
						  str+='<a href="/showUpdateWordForCouchingByUser?id='+data+'" id="editTrauncate" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>';
				             
						return str;
					}
											
			  return str;
			
			  
		  }
		 
	  }
	 
  ]
	
	
	
	
});
} 




var table=$('#viewalltutor');

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
		  
		  data:'id',
		  mRender:function(data){
			  				
			  var str='';
			
						
			  str+='<a href="/singleViewForTutor?id='+data+'" id="gmapjs" class="btn btn-primary">View Single</a>';
                	return str;
					
		  }
		  
	  }
	  ,
	  {
		  
		  data:'fullName',
		 
	  }
	  ,
	  {
		  data:'homeDistrict'
		 
		  
		  
	  },
	  {
		  data:'institutionType'
		 
	  },
	  {
		  data:'institution'
		 
	  },
	  {
		  data:'department'
		 
	  },
	  {
		  data:'year'
		 
	  },
	 
	  {
		  data:'experience'
		 
	  }
	  ,
	  {
		  data:'courses'
		  
	  }
	  ,
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
						
			  str+='<a href="/updateTutorByAdmin?id='+data+'" id="editTrauncate" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>';
                
						
					str+='<a href="/deleteTutorByAdmin?id='+data+'" id="editTrauncate" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a>';
					return str;
					}if (userRole=='USER') {
						  str+='<a href="/showUpdateWordForTutorByUser?id='+data+'" id="editTrauncate" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>';
				             
						return str;
					}
											
			  return str;
			
			  
		  }
		 
	  }
	 
  ]
	
	
	
	
});
} 















var table=$('#viewalljobtypes');

if(table.length){

	var jsonUrl=jsonurladmin1;
	

	 table.DataTable({
  lengthMenu:[[30,73,-1],['30 files','73 files','All']],
  pageLength:30,
  ajax:{
	  url:jsonUrl,
	  dataSrc : ''
	 
	  
  },
  columns : [
	  
	 
		
	  {
		  
		  data:'jobType',
		 
	  }
	  ,
	  {
		  data:'commonName'
		 
		  
		  
	  },
	  {
		  data:'lastModifiedDate'
		 
	  }
	  ,
	  {
		  data:'id',
		  mRender:function(data){
			  				
			  var str='';
					
		
						
			  str+='<a href="/editJobTypeByAdmin?id='+data+'" id="editTrauncateByAdmin" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>';
                
						
					str+='<a href="/deleteJobTypeByAdmin?id='+data+'" id="editTrauncateByAdmin" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a>';
					return str;
					
			  
		  }
		 
	  }
	 
  ]
	
	
	
	
});
} 




var table=$('#viewallinstitution');

if(table.length){

	var jsonUrl=jsonurladmin2;
	

	 table.DataTable({
  lengthMenu:[[30,73,-1],['30 files','73 files','All']],
  pageLength:30,
  ajax:{
	  url:jsonUrl,
	  dataSrc : ''
	 
	  
  },
  columns : [
	  
	 
		
	  {
		  
		  data:'institutionType',
		 
	  }
	  ,
	  {
		  data:'institutionName'
		 
		  
		  
	  },
	  {
		  data:'lastModifiedDate'
		 
	  }
	  ,
	  {
		  data:'id',
		  mRender:function(data){
			  				
			  var str='';
					
		
						
			  str+='<a href="/editInstitutionByAdmin?id='+data+'" id="editTrauncateByAdmin" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>';
                
						
					str+='<a href="/deleteInstitutionByAdmin?id='+data+'" id="editTrauncateByAdmin" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a>';
					return str;
					
			  
		  }
		 
	  }
	 
  ]
	
	
	
	
});
} 






