<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<sx:head debug="true" cache="false" compressed="false" />
</head>

<body>
	<s:form action="addCustomer" validate="true" method="post">
		<s:actionerror />
		<s:textfield name="customer.firstname" label="Firstname"
			value="%{customer.firstname}">
		</s:textfield>
		<s:textfield name="customer.lastname" label="Lastname" value="%{customer.lastname}">
		</s:textfield>
		<s:textfield name="customer.email" label="E-Mail" value="%{customer.email}">
		</s:textfield>
		<sx:datetimepicker name="customer.birthdate" label="Birthdate"
			value="%{customer.birthdate}" displayFormat="dd/MM/yyyy" />
		<s:select name="customer.sex" label="Sex"
			list="#{'Male':'Male','Female':'Female'}" value="%{customer.sex}" />
		<s:submit />
	</s:form>

</body>
</html>