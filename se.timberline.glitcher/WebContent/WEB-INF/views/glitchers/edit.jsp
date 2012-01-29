<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div>
	<h2>Create a free Glitcher account</h2>
	
	<sf:form method="POST" modelAttribute="glitcher" enctype="multipart/form-data">
		<fieldset>
			<table>
				<tr>
<<<<<<< HEAD
					<th><sf:label path="fullname">Full name:</sf:label></th>
					<td><sf:input path="fullname" size="15" id="fullname"/>
						<br/><sf:errors path="fullname" cssClass="error"/>
					</td> 
=======
					<th><label for="user_full_name">Full name:</label></th>
					<td><sf:input path="fullname" size="15" id="user_full_name"/><br/>
						<sf:errors path="fullname" cssClass="error"/>
					</td>
>>>>>>> branch 'master' of https://thesam@github.com/thesam/glitcherweb.git
				</tr>
				<tr>
<<<<<<< HEAD
					<th><sf:label path="username">Username:</sf:label></th>
					<td><sf:input path="username" size="15" maxlength="15" id="username"/>
					<small id="username_msg">No spaces, please</small>
						<br/><sf:errors path="username" cssClass="error"/>
					</td> 
=======
					<th><label for="user_screen_name">Username:</label></th>
					<td><sf:input path="username" size="15" maxlength="15" id="user_screen_name"/>
					<small id="username_msg">No spaces, please</small><br/>
					<sf:errors path="username" cssClass="error"/>
					</td>
>>>>>>> branch 'master' of https://thesam@github.com/thesam/glitcherweb.git
				</tr>
				<tr>
<<<<<<< HEAD
					<th><sf:label path="password">Password:</sf:label></th>
					<td><sf:password path="password" size="30" showPassword="true" id="password"/>
					<small>6 characters or more (be tricky!)</small>
						<br/><sf:errors path="password" cssClass="error"/>
					</td> 
				</tr>
				<tr>
					<th><label for="image">Profile image:</label></th>
					<td><input name="image" type="file"/></td>
=======
					<th><label for="user_password">Password:</label></th>
					<td><sf:password path="password" size="30" showPassword="true" id="user_password"/>
					<small>6 characters or more (be tricky!)</small><br/>
					<sf:errors path="password" cssClass="error"/>
					</td>
>>>>>>> branch 'master' of https://thesam@github.com/thesam/glitcherweb.git
				</tr>
			</table>
			<input type="submit">
		</fieldset>
	</sf:form>
</div>
