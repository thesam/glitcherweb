<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div>
	<h2>Create a free Glitcher account</h2>
	
	<sf:form method="POST" modelAttribute="glitcher" enctype="multipart/form-data">
		<fieldset>
			<table>
				<tr>
					<th><label for="user_full_name">Full name:</label></th>
					<td><sf:input path="fullname" size="15" id="user_full_name"/></td>
				</tr>
				<tr>
					<th><label for="user_screen_name">Username:</label></th>
					<td><sf:input path="username" size="15" maxlength="15" id="user_screen_name"/>
					<small id="username_msg">No spaces, please</small></td>
				</tr>
				<tr>
					<th><label for="user_password">Password:</label></th>
					<td><sf:password path="password" size="30" showPassword="true" id="user_password"/>
					<small>6 characters or more (be tricky!)</small></td>
				</tr>
				<tr>
					<th><label for="image">Profile image:</label></th>
					<td><input name="image" type="file"/></td>
				</tr>
			</table>
			<input type="submit">
		</fieldset>
	</sf:form>
</div>