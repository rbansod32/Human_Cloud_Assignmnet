<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wallet-Dashboard</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>

<style type="text/css">

body{
  background: lightblue;
}
 
.content{
  width: 60%;
  height: auto;
  margin: 0 auto;
  padding: 60px;
}

.nav-pills{
  width: 100%;
}

.nav-item{
  width: 30%;
}

.nav-pills .nav-link{
  font-weight: bold;
  padding-top: 13px;
  text-align: center;
  background: #343436;
  color: #fff;
  border-radius: 30px;
  height: 100px;
}
.nav-pills .nav-link.active{
  background: #fff;
  color: #000;
}
.tab-content{
  position: absolute;
  width: 50%;
  height: auto;
  margin-top: -50px;
  background: #fff;
  color: #000;
  border-radius: 30px;
  z-index: 1000;
  box-shadow: 0px 10px 10px rgba(0, 0, 0, 0.4);
  padding: 30px;
  margin-bottom: 50px;
}
.tab-content button{
  border-radius: 40px;
  width: 150px;
  margin: 70px auto;
  float: right;
}

</style>

</head>
<body>
	
	<div class="content">
	
		<input type="hidden" id="loginUserName"/>
		<input type="hidden" id="loginContactNo"/>
	
	    <!-- Nav pills -->
	    <ul class="nav nav-pills" role="tablist" id="dashboardTab">
	      <li class="nav-item">
	        <a class="nav-link active" data-toggle="pill" href="#home">Home</a>
	      </li>
	      <li class="nav-item" id="txnTabPill">
	        <a class="nav-link" data-toggle="pill" href="#transactions">Transactions</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" data-toggle="pill" href="#profile">Profile</a>
	      </li>
	    </ul>
	
	    <!-- Tab panes -->
	    <div class="tab-content">
	      
	      <div id="home" class="container tab-pane active">
	        <form>
	        	
	        	<table>
	        		
	        		<tr><td><p id="welcomeUserName"></p></td></tr>
	        		</br>
	        		<tr><td><p id="walletBalance"></p></td></tr>
	        		
	        		<tr>
	        			<td>
	        				<button type="button" class="btn btn-info form-group" data-toggle="modal" data-target="#addFundModal">
					          <i class='fas fa-wallet'></i> Add Funds
					        </button>
	        			</td>
	        			
	        			<td>
	        				<button type="button" class="btn btn-info form-group" data-toggle="modal" data-target="#sendFundModal">
					          <i class='far fa-paper-plane'></i> Send Funds
					        </button>
	        			</td>
	        			
	        		</tr>
	        			        		
	        	</table>
	        	
	        </form>
	      </div>
	      
	      <div id="transactions" class="container tab-pane fade" style="margin: auto; padding-left: 20%;">
	        
	      </div>
	      
	      <div id="profile" class="container tab-pane fade">
	        
	        <form>
	          
	          <input type="text" class="form-control form-group" id="profileFirstName" placeholder="First Name">
	          <input type="text" class="form-control form-group" id="profileLastName" placeholder="Last Name">
	          <input type="text" class="form-control form-group" id="profileContactNo" placeholder="Contact No">
	          <input type="text" class="form-control form-group" id="profileEmail" placeholder="Email">
	          <input type="text" class="form-control form-group" id="profileCity" placeholder="City">
	          <input type="text" class="form-control form-group" id="profileState" placeholder="State">
	          <input type="text" class="form-control form-group" id="profileCountry" placeholder="Country">
	          <input type="text" class="form-control form-group" id="profilePincode" placeholder="Pincode">
	          
	          <button type="submit" class="btn btn-primary" id="updateUserInfo">Update</button>
	          
	        </form>
	      
	      </div>
	      
	    </div>
	    
	  </div>
	  
	  
	  <!-- Add Fund Modal -->
	  <div class="modal fade" id="addFundModal" role="dialog">
	    <div class="modal-dialog modal-md">
	      <div class="modal-content">
	        <div class="modal-header">
	          <h4 class="modal-title">Add Fund To Wallet</h4>
	        </div>
	        <div class="modal-body">
	          <input type="text" class="form-control form-group" id="addAmount" placeholder="Add Amount">
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-primary" id="addFundToWallet">Add</button>
	          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
	        </div>
	      </div>
	    </div>
	  </div>
	  
	  
	  <!-- Send Fund Modal -->
	  <div class="modal fade" id="sendFundModal" role="dialog">
	    <div class="modal-dialog modal-md">
	      <div class="modal-content">
	        <div class="modal-header">
	          <h4 class="modal-title">Transfer Funds</h4>
	        </div>
	        <div class="modal-body">
	          <input type="text" class="form-control form-group" id="toContactNo" placeholder="Receivers Contact No">
	          <input type="text" class="form-control form-group" id="toAmount" placeholder="Amount">
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-success" id="sendFund">Send</button>
	          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
	        </div>
	      </div>
	    </div>
	  </div>
	
</body>

<script>

$(document).ready(function() {
	
	var username = GetURLParameter('username');
	var userInfo = GetURLParameter('userInfo');
	
	var userServiceLink = "http://localhost:8082/";
	var walletServiceLink = "http://localhost:8083/";
	
	var walletBalance = userInfo.split("|")[1];
	
	var loginUserName = username;
	var loginContactNo = userInfo.split("|")[0];
	
	$("#welcomeUserName").text("Welcome " + username);
	$("#walletBalance").text("Available Fund : 3741.0");
	
	$("#addFundToWallet").click(function() {
		
		var link = walletServiceLink + "addWalletFund";
		
		var amt = $("#addAmount").val();
		
		//loginUserName = "rbansod32";
		//loginContactNo = "8793874581"
		
		$.ajax({
            
			url: link,
            type: "POST",
            dataType: "json",
            data: {
            	Username: loginUserName,
            	Amt: amt
            },
            success: function(response) {
            	
            	if(response.responseMessage == "SUCCESS"){
            		alert("Fund added..!!");
            		$("#addAmount").val('');
            	}else{
            		alert("Failed to add funds..!!");
            	}
            	
            }
            
        });
		
		
	});
	
	
	$("#sendFund").click(function() {
		
		var link = walletServiceLink + "transferFund";
		var amt = $("#toAmount").val();
		var contactNo = $("#toContactNo").val();
		
		//loginUserName = "rbansod32";
		//loginContactNo = "8793874581"
		
		$.ajax({
            
			url: link,
            type: "POST",
            dataType: "json",
            data: {
            	Username: loginUserName,
            	SenderContactNo: loginContactNo,
            	ReceiverContactNo: contactNo,
            	Amt: amt
            },
            success: function(response) {
            	
            	if(response.responseMessage == "SUCCESS"){
            		alert("Fund tranferred..!!");
            		$("#toContactNo").val('');
            		$("#toAmount").val('');
            	}else{
            		alert("Failed to transfer funds..!!");
            	}
            	
            }
            
        });
		
	});
	
	
	$('#txnTabPill').click(function() {
		
		var link = walletServiceLink + "showTransactions";
		debugger;
		//loginUserName = "rbansod32";
		//loginContactNo = "8793874581"
		
		$.ajax({
            
			url: link,
            type: "POST",
            dataType: "json",
            data: {
            	ContactNo: loginContactNo
            },
            success: function(response) {
            	
            	var txnData = JSON.parse(response.responseData);
            	var txnCard = "";
            	
            	$("#transactions").html('');
            	
            	$.each(txnData, function(i, allTxn) {
            	    
            		$.each(allTxn, function(i, singleTxn) {

            			var txnType = "";
            			var txnAmt = "";
            			var name = "";
            			var date = singleTxn.Txn_Date;
            			
            			if(singleTxn.Txn_Type == "C"){
            				
            				txnType = "<i class='fas fa-angle-double-down' style='font-size:30px;color:green'></i>";
            				txnAmt = "<i class='fas fa-rupee-sign' style='font-size:30px;color:green'>"+singleTxn.Cr_Amt+"</i>";
            				name = singleTxn.Cr_Contact_No;
            			
            			}else if(singleTxn.Txn_Type == "D"){
            				
            				txnType = "<i class='fas fa-angle-double-up' style='font-size:30px;color:red'></i>";
            				txnAmt = "<i class='fas fa-rupee-sign' style='font-size:30px;color:red'>"+singleTxn.Dr_Amt+"</i>";
            				name = singleTxn.Dr_Contact_No;
            			
            			}
            			
            			txnCard += "<div class='card' style='width:70%'>"+
            								"<div class='card-body' style='padding: 10px;'>"+
    											"<table style='width:100%'>"+
    												"<tr>"+
    													"<td style='width:20%'>"+txnType+"</td>"+
    													"<td style='width:60%'>"+
    														"<p>"+name+"</p>"+
    														"<p>"+date+"</p>"+
    													"</td>"+
    													"<td style='width:20%'>"+txnAmt+"</td>"+
    												"</tr>"+
    											"</table>"+
    										"</div>"+
      									"</div></br>";
            			
            			
            		});
            		
            	});
            	
            	
            	$("#transactions").append(txnCard);
            	
            }
            
        });
		
	});
		
	
	$("#updateUserInfo").click(function() {
		
		var username = loginUserName;
		var profileFirstName = $("#profileFirstName").val();
		var profileLastName = $("#profileLastName").val();
		var profileContactNo = $("#profileContactNo").val();
		var profileEmail = $("#profileEmail").val();
		var profileCity = $("#profileCity").val();
		var profileState = $("#profileState").val();
		var profileCountry = $("#profileCountry").val();
		var profilePincode = $("#profilePincode").val();
		
		var link = userServiceLink + "addUserInfo";
		
		$.ajax({
            
			url: link,
            type: "POST",
            dataType: "json",
            data: {
            	username: username,
            	FirstName: profileFirstName,
            	LastName: profileLastName,
            	ContactNo: profileContactNo,
            	Email: profileEmail,
            	City: profileCity,
            	State: profileState,
            	Country: profileCountry,
            	Pincode: profilePincode
            },
            success: function(response) {
            	
            	if(response.responseMessage == "SUCCESS"){
            		alert("Details updated...!!");
            	}else{
            		alert(response.responseMessage);
            	}
            	
            }
            
        });
		
		
	});
	
});

function GetURLParameter(sParam){
	
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) {
    	
        var sParameterName = sURLVariables[i].split('=');
        
        if (sParameterName[0] == sParam) {
            return decodeURIComponent(sParameterName[1]);
        }
    }
}

</script>

</html>




