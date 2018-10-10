
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
		  data:'id',
		  mRender:function(data){
			  				
			  var str='';
				var id=data;	
		
					if (userRole=='ADMIN') {
							
			  return id;
			
			  
		  }else {
			return str;
		}
	  }
	  },
	 
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
			   
			  str+='<button id="editTrauncate" class="btn btn-primary tag_cnt btn btn-danger"  onclick="showCouchingModal('+data+')" type="button" value="1"><span class="glyphicon glyphicon-trash"></span></button>';
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
	  {  data:'id',
		  mRender:function(data){
			  				
			  var str='';
				var id=data;	
		
					if (userRole=='ADMIN') {
							
			  return id;
			
			  
		  }else {
			return str;
		}
	  }
		  },
	 
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
                
			  str+='<button id="editTrauncate" class="btn btn-primary tag_cnt btn btn-danger"  onclick="showTutorModal('+data+')" type="button" value="1"><span class="glyphicon glyphicon-trash"></span></button>';
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
			data:'id'  
		  },
	 
		
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
			    
			  str+='<button id="editTrauncate" class="btn btn-primary tag_cnt btn btn-danger"  onclick="showJobTypeModal('+data+')" type="button" value="1"><span class="glyphicon glyphicon-trash"></span></button>';
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
			data:'id'  
		  },
	 
		
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
                
			  str+='<button id="editTrauncate" class="btn btn-primary tag_cnt btn btn-danger"  onclick="showInstitutionModal('+data+')" type="button" value="1"><span class="glyphicon glyphicon-trash"></span></button>';
				return str;
					
			  
		  }
		 
	  }
	 
  ]
	
	
	
	
});
} 
/*bootstrap modal*/
/*for tutor*/
function showTutorModal(data)
{
   //you can do anything with data, or pass more data to this function. i set this data to modal header for example
	 $('.tutorDeleteByAdmin').attr('href','/deleteTutorByAdmin?id='+data);
	$("#myModal .tutorDeleteId").html(data)
   $("#myModal").modal();
}

/*for couching*/
function showCouchingModal(data)
{
   //you can do anything with data, or pass more data to this function. i set this data to modal header for example
	 $('.couchingDeleteByAdmin').attr('href','/deleteCouchingByAdmin?id='+data);
	$("#myModal .couchingDeleteId").html(data)
   $("#myModal").modal();
}

/*for job type*/
function showJobTypeModal(data)
{
   //you can do anything with data, or pass more data to this function. i set this data to modal header for example
	 $('.jobtypeDeleteByAdmin').attr('href','/deleteJobTypeByAdmin?id='+data);
	$("#myJobTypeModal .jobtypeDeleteId").html(data)
   $("#myJobTypeModal").modal();
}


/*for institution*/
function showInstitutionModal(data)
{
   //you can do anything with data, or pass more data to this function. i set this data to modal header for example
	 $('.institutionDeleteByAdmin').attr('href','/deleteInstitutionByAdmin?id='+data);
	$("#myInstitutionModal .institutionDeleteId").html(data)
   $("#myInstitutionModal").modal();
}



