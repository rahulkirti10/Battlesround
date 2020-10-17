<html>
    <head>
        <script>
            function disp()
            {
               var e=document.getElementById("cng-photo");
               e.style.display="block";
            }
                        function ndisp()
            {
               var e=document.getElementById("cng-photo");
               e.style.display="none";
            }
            function underline()
            {
                var x=document.getElementById("underline2");
               x.style.display="none";
               var e=document.getElementById("underline");
               e.style.display="block";
               x=document.getElementById("content");
               x.style.display="block";
               x=document.getElementById("yours");
               x.style.display="none";
               x=document.getElementById("upl");
               x.style.display="block";
    x=document.getElementById("inputImg");
               x.style.display="none";
               x=document.getElementById("img");
               x.style.display="none";  
               x=document.getElementById("size");
               x.style.display="none";  
               
    }
            function underline2()
            {
               var e=document.getElementById("underline");
               e.style.display="none";
               var x=document.getElementById("underline2");
               x.style.display="block";
               x=document.getElementById("content");
               x.style.display="none";
               x=document.getElementById("yours");
               x.style.display="block";
               x=document.getElementById("upl");
               x.style.display="block";
               x=document.getElementById("inputImg");
               x.style.display="block";
               x=document.getElementById("size");
               x.style.display="block";  
            }
            function select(x)
            {
               var r1=document.getElementById("tick");
               var r2=document.getElementById("tick2");
               var r3=document.getElementById("tick3");
               var r4=document.getElementById("tick4");
               if(x===1)
               {
                   r1.style.display="block";
                   r2.style.display="none";
                   r3.style.display="none";
                   r4.style.display="none";
                   document.getElementById("blobUrl").value="photos/profile/kissclipart-icon-clipart-computer-icons-online-chat-avatar-a7afb5a6b53123e5.png";
               document.getElementById("status").value="2";
        }
                if(x===2)
               {
                   r1.style.display="none";
                   r2.style.display="block";
                   r3.style.display="none";
                   r4.style.display="none";
                   document.getElementById("blobUrl").value="photos/profile/hiclipart.com (1).png";
                   document.getElementById("status").value="2";
               }
                if(x===3)
               {
                   r1.style.display="none";
                   r2.style.display="none";
                   r3.style.display="block";
                   r4.style.display="none";
                   document.getElementById("blobUrl").value="photos/profile/PinClipart.com_boy-clipart-images_75346.png";
                   document.getElementById("status").value="2";
               }
                if(x===4)
               {
                   r1.style.display="none";
                   r2.style.display="none";
                   r3.style.display="none";
                   r4.style.display="block";
                   document.getElementById("blobUrl").value="photos/profile/5e4d06ec38652.png";
                   document.getElementById("status").value="2";
               }
              
            }
            function chk()
            {
              var x=1359731;  
              if(document.getElementById('sizeImg').value>x)
              { alert("maximum size exceed");
              return false;}
          return true;
            }
            </script>
            
    </head>
    <body >
         <center>
    <div class="cng-photo" id="cng-photo">
        <a href="#"onclick="ndisp()"> <p class="cross">X</p> </a>

        <a href="#" onclick="underline()" class="cng-type">Sample</a>
                <a href="#" onclick="underline2()" class="cng-type">Yours</a>
                <div id="underline" class="underline"></div>
                <div id="underline2" class="underline2"></div>
                <br><br><br>
                <div class="grid"></div><br><br>
        <div class="content" id="content">
            <table>
                <tr><td><div><button class="content-table" onclick="select(1)"><img src="photos/profile/kissclipart-icon-clipart-computer-icons-online-chat-avatar-a7afb5a6b53123e5.png" height="220px" width="220px"></button>
                    <div>
                        <img class="tick" id="tick" src="photos/tick/5e5393f370bd6.png" height="50px" width="50px;">
                    </div>
                </div></td>
                <td><div><button class="content-table" onclick="select(2)"><img src="photos/profile/hiclipart.com (1).png" height="220px" width="220px"></button>
                 <div>
                        <img class="tick2" id="tick2" src="photos/tick/5e5393f370bd6.png" height="50px" width="50px;">
                    </div></div></td>
               <td> <div><button class="content-table" onclick="select(3)"><img src="photos/profile/PinClipart.com_boy-clipart-images_75346.png" height="220px" width="220px"></button>
                <div>
                        <img class="tick3" id="tick3" src="photos/tick/5e5393f370bd6.png" height="50px" width="50px;">
                    </div></div></td>
                <td><div><button class="content-table" onclick="select(4)"><img src="photos/profile/5e4d06ec38652.png" height="220px" width="220px"></button>
                 <div>
                        <img class="tick4" id="tick4" src="photos/tick/5e5393f370bd6.png" height="50px" width="50px;">
                 </div></div></td></tr>          
                </table> 
    </div> <form action="change_photo" method="post" onsubmit="return chk();">
                <div class="yours" id="yours">
                    <b id="upl" style="color:grey; font-size:25px;display: none;">Upload photo:<p id="size" style=" display:none;color:red;font-size:20px;">Maximum Image Size:1.3 MB</p></b><input type="file" value="Uplaod Photo" name="upload" style="display:none;" class="browse" id="inputImg">
                </div>
        <img src="" id="img" height="280px" width="300px" style="display:none;">
                    <input type="hidden" name="photo" id="blobUrl">
                    <p id="wait" style="color:grey;font-size:20px;display:none;">Please wait.....</p>
                    <input type="hidden" name="status" value="1" id="status">
                    <input type="hidden" name="status" value="1" id="sizeImg">
                 <input type="submit" value="change" class="change">
                </form>
                </div>
    </center>
    <script>
    var blobURL;
var fileName;

function convertDataURIToBinary(dataURI) {
	var BASE64_MARKER = ';base64,';
	var base64Index = dataURI.indexOf(BASE64_MARKER) + BASE64_MARKER.length;
	var base64 = dataURI.substring(base64Index);
	var raw = window.atob(base64);
	var rawLength = raw.length;
	var array = new Uint8Array(new ArrayBuffer(rawLength));

	for(i = 0; i < rawLength; i++) {
		array[i] = raw.charCodeAt(i);
	}
	return array;
}
function readFile(evt) {
    var f = evt.target.files[0]; 
 document.getElementById('wait').style.display = "block";
    if (f) {
		if ( /(jpe?g|png|gif)$/i.test(f.type) ) {
			var r = new FileReader();
			r.onload = function(e) { 
				var base64Img = e.target.result;
				var binaryImg = convertDataURIToBinary(base64Img);
				var blob = new Blob([binaryImg], {type: f.type});
				blobURL = window.URL.createObjectURL(blob);
				fileName = f.name;
				
				document.getElementById('blobUrl').value = base64Img;
                                document.getElementById('img').src = base64Img;
                                	document.getElementById('sizeImg').value = f.size;
                                 document.getElementById('img').style.display="block";
				document.getElementById('wait').style.display = "none";
		
			
			}
			r.readAsDataURL(f);
		} else { 
			alert("Failed file type");
		}
    } else { 
		alert("Failed to load file");
    }
}

var downloadFile = (function () {
    var a = document.createElement("a");
    document.body.appendChild(a);
    a.style = "display: none";
    return function () {
        a.href = blobURL;
        a.download = fileName;
        a.click();
        window.URL.revokeObjectURL(blobURL);
    };
}());

document.getElementById('inputImg').addEventListener('change', readFile, false);
document.getElementById('saveImg').addEventListener('click', downloadFile, false);
 </script>   
</body>