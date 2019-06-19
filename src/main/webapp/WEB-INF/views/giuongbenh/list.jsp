<%--
  Created by IntelliJ IDEA.
  User: LeDang
  Date: 29/05/2019
  Time: 3:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title> Quản lý Loại Giường Bệnh</title>
    <link href="<c:url value="/resources/css/list.css" />"  rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <c:url  var="edit"   value="/giuongbenh/editform" />
    <c:url  var="addnew" value="/giuongbenh/addnew" />
    <c:url  var="search" value="/giuongbenh/search" />
    <c:url  var="save" value="/giuongbenh/save" />
</head>
<body>
<div id="body_content">
    <div id = "wrap">
        <div id="banner">
            <img id="logo" src="http://localhost:8081/test_war_exploded/resources/image/logoyhoc.jpg">
            <div id="text_banner">
                <h4> BỆNH VIỆN XYZ</h4>
                <h6>QUẢN LÝ LOẠI GIƯỜNG BỆNH</h6>
            </div>

            <div id="account" ><img src="https://png.icons8.com/windows/50/000000/contacts.png">
                <label>Admin</label>
                <ul id="menu-account">
                    <li>&nbsp;
                        <ul >
                            <li>Thông tin</li>
                            <li><a href="#" style="text-decoration:none">Đăng xuất</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div id="Content_form">
            <div style="margin: 0px; height: 1px;"></div>
            <div id="search_code_user">
                <form id="search_form" action="${search}" method="post">
                    <input type="search" id="txtsearch" name="txtsearch" placeholder="Nhập thông tin tìm kiếm">
                    <input type="submit" id="btnsearch" name="btnsearch" value ="TÌM">
                </form>
            </div>
            <div id="Sys_management_mailbox_header" >
                <label><b>Quản Lý Loại Giường Bệnh</b></label>
            </div>
            <div id="Sys_management_mailbox_body">
                <div id="Sys_management_mailbox_body_left" >
                   <!-- <a href="${addnew}" > <button data-toggle="modal" data-target="#myModal"   class="btn" name="btnAdd_new_mailbox" id="btnAdd_new_mailbox">Thêm loại giường bệnh</button></a>-->
                    <button data-toggle="modal" data-target="#myModal"   class="btn" name="btnAdd_new_mailbox" id="btnAdd_new_mailbox">Thêm loại giường bệnh</button>
                    <button data-toggle="modal" data-target="#myModal"   class="btn" name="phan_quyen" id="phan_quyen">Sửa loại giường bệnh</button>
                </div>

                <div id="Sys_management_mailbox_body_right" >
                    <div style=" width:100%; height: 40px; margin:0px">
                        <table id="table_info">
                            <tr>
                                <th width="5%" > Chọn </th>
                                <th  width="15%"> ID</th>
                                <th  width="20%">Tên</th>
                                <th  width="20%">Giá</th>
                                <th  width="25%">Miêu tả</th>
                                <th  width="15%"> Bộ chọn </th>
                            </tr>
                        </table>
                    </div>
                    <div  style="overflow-y:auto; width:100%; height: 250px;">

                        <table id="table_info">

                            <c:forEach items="${listResult}" var="item">
                                <tr>
                                    <td width="5%" ><input type="checkbox" /></td>
                                    <td style="width: 15%; text-align: center"> ${item.id}    </td>
                                    <td style="width: 20%; text-align: center"> ${item.name}  </td>
                                    <td style="width: 20%;text-align: center"> ${item.price} </td>
                                    <td style="width: 25%;text-align:left"> ${item.description}</td>
                                    <td width="15%">

												<label><img src="http://localhost:8081/test_war_exploded/resources/image/view.png" style="cursor: pointer; width: 30px; height: 30px;"></label>
                                        |
												<label><a href="${edit}?id=${item.id}&command=edit" /> <img src="http://localhost:8081/test_war_exploded/resources/image/edit.png" style=" cursor: pointer; width: 30px; height: 30px;"></label>
                                        |
												<label><a href="<c:url value="/giuongbenh/delete?id=${item.id}"/>" /><img src="http://localhost:8081/test_war_exploded/resources/image/delete.png" style=" cursor: pointer; width: 30px; height: 30px;"></label>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-xl" style="max-width: 1140px!important;">
        <div id="content-data">
            <form  method="post" action="${save}">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-uppercase text-center">Điền thông tin</h5>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body" >

                        <label><small>Chú ý nhé! đánh dấu (<span style="color: red">*</span>) bạn không được để trống</small></label>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="txtid">Tên loại giường bệnh:(<span style="color: red">*</span>)</label>
                                <input type="text" class="form-control" id="txtid" name="name"  />
                            </div>

                            <div class="form-group col-md-6">
                                <label for="txttenThietBi">Giá:(<span style="color: red">*</span>)</label>
                                <input type="text" class="form-control" id="txttenThietBi" name="price" />
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label for="id_comment">Mô tả:(<span style="color: red">*</span>)</label>
                                <label id="error_comment" style="display: none;"><small><span style="color: red">Bạn cần điền "Mô tả" để thao tác thành công nhé!</span></small></label>

                                <textarea rows="10"  class="form-control" name="description" id="id_comment" required ></textarea>
                            </div>
                        </div>

                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" name="btnSave" id="btnsave">Lưu</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                </div>
            </div>
            </form>
        </div>

    </div>
</div>
</body>
</html>
