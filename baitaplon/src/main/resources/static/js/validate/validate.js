/**
 * 
 */
function checkemail(val) {
	pat = /^[a-zA-Z0-9-_]+@[a-z0-9]+(\.[a-z]{2,3}){1,2}$/;
	gt = val.match(pat);
	return gt;
}
function checkPC() {
	tenNN = $('#NguoiNhanTien');
	diachi = $("#DiaChi");
	ngaylapphieu = $("#NgayLapPhieu");
	lido = $("#LiDo");
	sotien = $("#SoTien");
	hinhanh = $("#HinhAnh");
	nguoiLP = $("#NguoiLapPhieu");
	giamdoc = $("#GiamDoc");
	if (tenNN.val() == "") {
		alert("Chưa nhập tên người nhận");
		tenNN.focus();
		return false;
	} else if (diachi.val() == "") {
		alert("Chưa nhập địa chỉ");
		diachi.focus();
		return false;
	} else if (ngaylapphieu.val() == "") {
		alert("Chưa nhập ngày lập phiếu");
		ngaylapphieu.focus();
		return false;
	} else if (lido.val() == "") {
		alert("Chưa nhập lí do");
		lido.focus();
		return false;
	}
	// else if ($("#cbox").prop("checked")==false) {
	// ten.css('background-image','linear-gradient(to bottom, #A60ECC,
	// #D2D2D2)');
	// ten.removeAttr('title');
	// email.css('background-image','linear-gradient(to bottom, #A60ECC,
	// #D2D2D2)');
	// email.removeAttr('title');
	// mk.css('background-image','linear-gradient(to bottom, #A60ECC,
	// #D2D2D2)');
	// mk.removeAttr('title');
	// cmk.css('background-image','linear-gradient(to bottom, #A60ECC,
	// #D2D2D2)');
	// cmk.removeAttr('title');
	// /**/
	// alert("Bạn phải chấp nhận điều khoản và điều kiện của chúng tôi");
	// return false;
	// }
	else if (sotien.val() == "") {
		alert("Chưa nhập số tiền");
		sotien.focus();
		return false;
	} else if (hinhanh.val() == "") {
		alert("Chưa nhập hình ảnh");
		hinhanh.focus();
		return false;
	} else if (nguoiLP.val() == "") {
		alert("Chưa nhập tên người lập phiếu");
		nguoiLP.focus();
		return false;
	} else if (giamdoc.val() == "") {
		alert("Chưa nhập tên giám đốc");
		giamdoc.focus();
		return false;
	} 
	return true;
}

function checkPDX() {
	nguoinhan = $("#NguoiNhan");
	nguoidexuat = $("#NguoiDeXuat");
	noidungdexuat = $("#NoiDungDeXuat");
	ngaybatdau = $("#ngaybatdau");
	ngayhoanthanh = $("#NgayHoanThanh");
	ykien = $("#YKien");
	ndx = $("#NDX");
	kt = $("#KT");
	gd = $("#GD");
	if (nguoinhan.val() == "") {
		alert("Chưa nhập tên người nhận");
		nguoinhan.focus();
		return false;
	} else if (nguoidexuat.val() == "") {
		alert("Chưa nhập người đề xuất");
		nguoidexuat.focus();
		return false;
	}
	else if (noidungdexuat.val() == "") {
		alert("Chưa nhập nội dung đề xuất");
		noidungdexuat.focus();
		return false;
	}
	else if (ngaybatdau.val() == "" ) {
		alert("Chưa nhập ngày bắt đầu");
		ngaybatdau.focus();
		return false;
	}
	else if (ngayhoanthanh.val() == "") {
		alert("Chưa nhập ngày hoàn thành");
		ngayhoanthanh.focus();
		return false;
	}
	else if (ykien.val() == "") {
		alert("Chưa nhập ý kiến");
		ykien.focus();
		return false;
	}
	else if (ndx.val() == "") {
		alert("Chưa nhập người đề xuất");
		ndx.focus();
		return false;
	}
	else if (kt.val() == "") {
		alert("Chưa nhập người kế toán");
		kt.focus();
		return false;
	}
	else if (gd.val() == "") {
		alert("Chưa nhập tên sếp");
		gd.focus();
		return false;
	}
}


