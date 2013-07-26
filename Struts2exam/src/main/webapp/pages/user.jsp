<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<head>
<sx:head debug="false" cache="false" compressed="false" />
<link href="css/displaytag.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<h2>List of customers</h2>
	<s:form action="removeCustomer" theme="simple">
		<display:table id="data" name="customerList" requestURI="listUser"
			pagesize="5">
			<display:column property="firstname" title="Firstname"
				sortable="true" />
			<display:column property="lastname" title="Lastname" sortable="true" />
			<display:column property="email" title="Email" sortable="true" />
			<display:column property="age" title="Age" sortable="true" />
			<display:column property="sex" title="Sex" sortable="true" />
			<display:column url="/removeCustomer" paramId="id" paramProperty="id"
				title="Remove" value="Remove" />
		</display:table>
	</s:form>
	<s:url action="toAddForm" var="urlTagAdd" />
	<s:a href="%{urlTagAdd}" style="font-size:20px;"> ADD CUSTOMER </s:a>
</body>
</html>