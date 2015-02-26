<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Kehadiran</title>
    </head>
    <body>
        <h1>Data Kehadiran</h1>

        <form>

            Karyawan : 
            <select name="idKaryawan">
                <option value="">Pilih Karyawan</option>
                <c:forEach var="k" items="${dataKaryawan}">
                    <option value="${k.id}">${k.nama}</option>
                </c:forEach>
            </select>
            
            <br>
            
            Periode : <input name="mulai" value="${mulai}"> - <input name="sampai" value="${sampai}">
            
            <br>

            <input type="submit" value="Cari" />

        </form>

        <hr>
        
        <c:if test="${empty dataKehadiran}" >
            Data tidak ada
        </c:if>
        <c:if test="${not empty dataKehadiran}" >
            <table border="1">
                <thead>
                    <tr>
                        <th>Tanggal</th>
                        <th>Datang</th>
                        <th>Pulang</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="k" items="${dataKehadiran}">
                    <tr>
                        <td><fmt:formatDate type="date" value="${k.datang}"></fmt:formatDate></td>
                        <td><fmt:formatDate type="time" value="${k.datang}"></fmt:formatDate></td>
                        <td><fmt:formatDate type="time" value="${k.pulang}"></fmt:formatDate></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

    </body>
</html>
