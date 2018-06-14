/**
 * 
 */
function checkemail(val){
    	pat=/^[a-zA-Z0-9-_]+@[a-z0-9]+(\.[a-z]{2,3}){1,2}$/;
    	gt=val.match(pat);
    	return gt;
}
function checkPC(){
    tenNN=$('#TenNguoiNhan');
    diachi=$("#DiaChi");
    ngaylapphieu=$("#NgayLapPhieu");
    lido=$("#LiDo");
    sotien=$("#SoTien");
    hinhanh=$("#HinhAnh");
    nguoiLP=$("#NguoiLapPhieu");
    giamdoc=$("#GiamDoc");
    if (tenNN.val()=="") {
        /*remove danger*/
    	diachi.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	diachi.removeAttr('title');
    	ngaylapphieu.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	ngaylapphieu.removeAttr('title');
    	lido.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	lido.removeAttr('title');
    	sotien.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	sotien.removeAttr('title');
    	hinhanh.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	hinhanh.removeAttr('title');
    	nguoiLP.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	nguoiLP.removeAttr('title');
    	giamdoc.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	giamdoc.removeAttr('title');
        /*add danger*/
        tenNN.css('background-image','linear-gradient(to bottom, #F93C09, #D2D2D2)');
        alert("Chưa nhập tên người nhận");
        tenNN.focus();
        return false;
    }
    else if (diachi.val()=="") {
        tenNN.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
        tenNN.removeAttr('title');
        ngaylapphieu.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	ngaylapphieu.removeAttr('title');
    	lido.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	lido.removeAttr('title');
    	sotien.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	sotien.removeAttr('title');
    	hinhanh.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	hinhanh.removeAttr('title');
    	nguoiLP.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	nguoiLP.removeAttr('title');
    	giamdoc.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	giamdoc.removeAttr('title');
        /**/
        diachi.css('background-image','linear-gradient(to bottom, #F93C09, #D2D2D2)');
        alert("Chưa nhập địa chỉ");
        diachi.focus();
        return false;
    }
    else if (ngaylapphieu.val()=="") {
    	tenNN.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
        tenNN.removeAttr('title');
        diachi.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	diachi.removeAttr('title');
    	lido.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	lido.removeAttr('title');
    	sotien.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	sotien.removeAttr('title');
    	hinhanh.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	hinhanh.removeAttr('title');
    	nguoiLP.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	nguoiLP.removeAttr('title');
    	giamdoc.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	giamdoc.removeAttr('title');
        /**/
    	ngaylapphieu.css('background-image','linear-gradient(to bottom, #F93C09, #D2D2D2)');
    	alert("Chưa nhập ngày lập phiếu");
    	ngaylapphieu.focus();
        return false;
    }
    else if (lido.val()=="") {
    	tenNN.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
        tenNN.removeAttr('title');
        diachi.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	diachi.removeAttr('title');
    	ngaylapphieu.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	ngaylapphieu.removeAttr('title');
    	sotien.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	sotien.removeAttr('title');
    	hinhanh.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	hinhanh.removeAttr('title');
    	nguoiLP.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	nguoiLP.removeAttr('title');
    	giamdoc.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	giamdoc.removeAttr('title');
        /**/
    	lido.css('background-image','linear-gradient(to bottom, #F93C09, #D2D2D2)');
    	alert("Chưa nhập lí do");
    	lido.focus();
        return false;
    }
//  else if ($("#cbox").prop("checked")==false) {
//    ten.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
//    ten.removeAttr('title');
//    email.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
//    email.removeAttr('title');
//    mk.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
//    mk.removeAttr('title');
//    cmk.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
//    cmk.removeAttr('title');
//    /**/
//    alert("Bạn phải chấp nhận điều khoản và điều kiện của chúng tôi");
//    return false;
//}
    else if(sotien.val()==""){
    	tenNN.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
        tenNN.removeAttr('title');
        diachi.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	diachi.removeAttr('title');
    	ngaylapphieu.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	ngaylapphieu.removeAttr('title');
    	lido.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	lido.removeAttr('title');
    	hinhanh.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	hinhanh.removeAttr('title');
    	nguoiLP.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	nguoiLP.removeAttr('title');
    	giamdoc.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	giamdoc.removeAttr('title');
        /**/
    	sotien.css('background-image','linear-gradient(to bottom, #F93C09, #D2D2D2)');
    	alert("Chưa nhập số tiền");
    	sotien.focus();
        return false;
    }
    else if(hinhanh.val()==""){
    	tenNN.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
        tenNN.removeAttr('title');
        diachi.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	diachi.removeAttr('title');
    	ngaylapphieu.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	ngaylapphieu.removeAttr('title');
    	lido.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	lido.removeAttr('title');
    	sotien.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	sotien.removeAttr('title');
    	nguoiLP.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	nguoiLP.removeAttr('title');
    	giamdoc.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	giamdoc.removeAttr('title');
        /**/
    	hinhanh.css('background-image','linear-gradient(to bottom, #F93C09, #D2D2D2)');
    	alert("Chưa nhập hình ảnh");
    	hinhanh.focus();
        return false;
    }
    else if(nguoiLP.val()==""){
    	tenNN.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
        tenNN.removeAttr('title');
        diachi.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	diachi.removeAttr('title');
    	ngaylapphieu.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	ngaylapphieu.removeAttr('title');
    	lido.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	lido.removeAttr('title');
    	sotien.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	sotien.removeAttr('title');
    	hinhanh.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	hinhanh.removeAttr('title');
    	giamdoc.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	giamdoc.removeAttr('title');
        /**/
    	nguoiLP.css('background-image','linear-gradient(to bottom, #F93C09, #D2D2D2)');
    	alert("Chưa nhập tên người lập phiếu");
    	nguoiLP.focus();
        return false;
    }
    else if(giamdoc.val()==""){
    	tenNN.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
        tenNN.removeAttr('title');
        diachi.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	diachi.removeAttr('title');
    	ngaylapphieu.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	ngaylapphieu.removeAttr('title');
    	lido.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	lido.removeAttr('title');
    	sotien.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	sotien.removeAttr('title');
    	hinhanh.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	hinhanh.removeAttr('title');
    	nguoiLP.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	nguoiLP.removeAttr('title');
        /**/
    	giamdoc.css('background-image','linear-gradient(to bottom, #F93C09, #D2D2D2)');
    	alert("Chưa nhập tên giám đốc");
    	giamdoc.focus();
        return false;
    }else{
    	tenNN.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
        tenNN.removeAttr('title');
        diachi.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	diachi.removeAttr('title');
    	ngaylapphieu.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	ngaylapphieu.removeAttr('title');
    	lido.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	lido.removeAttr('title');
    	sotien.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	sotien.removeAttr('title');
    	hinhanh.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	hinhanh.removeAttr('title');
    	nguoiLP.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	nguoiLP.removeAttr('title');
    	giamdoc.css('background-image','linear-gradient(to bottom, #A60ECC, #D2D2D2)');
    	giamdoc.removeAttr('title');
    alert("Thêm thành công");
}    
}