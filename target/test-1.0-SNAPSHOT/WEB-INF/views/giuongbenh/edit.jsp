<%--
  Created by IntelliJ IDEA.
  User: LeDang
  Date: 30/05/2019
  Time: 10:57 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- jstl core tag ( thẻ kiểm soát các hành vi trang -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Sua loại giường bệnh</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <c:url var="edit" value="/giuongbenh/CreateOrEdit" />
    <link href="<c:url value="/resources/css/list.css" />"  rel="stylesheet">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>
<body>
<form:form action="${edit}" method="get" commandName ="gb">

    <div class="modal-dialog modal-xl" style="max-width: 1140px!important;">
        <div id="content-data">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-uppercase text-center">Điền thông tin</h5>
                    <input type="submit" class="btn btn-primary"  value="X" ></input>
                </div>
                <div class="modal-body" >
                    <form class="form-horizontal" id="helpdesk" method="POST" action="#">
                        <label><small>Chú ý nhé! đánh dấu (<span style="color: red">*</span>) bạn không được để trống</small></label>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="txtname">Tên loại giường bệnh:(<span style="color: red">*</span>)</label>
                                <form:input type="text" class="form-control" id="txtname" name="txtname" path="name"  />
                            </div>
                            <br>

                            <div class="form-group col-md-6">
                                <label for="txtgia">Giá:(<span style="color: red">*</span>)</label>
                                <form:input type="text" class="form-control" id="txtgia" name="txtgia" path="price" />
                            </div>
                        </div>
                        <br>
                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label for="id_comment">Miêu tả:(<span style="color: red">*</span>)</label>
                                <label id="error_comment" style="display: none;"><small><span style="color: red">Bạn cần điền "Mô tả" để thao tác thành công nhé!</span></small></label>

                                <form:textarea rows="10"  class="form-control" name="comment" id="id_comment" path="description" ></form:textarea>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <form:hidden path="id" />
                    <!-- <input type="hidden" name="command" value="SaveOrEdit" /> -->
                    <input type="submit" class="btn btn-primary" name="btnSave" id="btnSave" value="Save" ></input>
                    <input type="submit" class="btn btn-primary" name="btnDelete" id="btnDelete" value="Hủy" ></input>
                </div>
            </div>
        </div>
    </div>
    </div>

</form:form>
</body>
</html>
