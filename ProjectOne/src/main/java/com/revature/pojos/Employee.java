package com.revature.pojos;

public class Employee
	{
		//no args constructor
		public Employee() {
		super();
	}
		
		//args constructor
		public Employee(String firstname, String lastname, String username, String password, boolean supervisor, boolean depthead, boolean benco) {
		super();
		this.firstname = firstname;
		this.lastname =lastname;
		this.username = username;
		this.password = password;
		this.supervisor = supervisor;
		this.depthead = depthead;
		this.benco = benco;
	}
		
		//fields
		private String username;
		private String password;
		private String firstname;
		private String lastname;
		private boolean supervisor;
		private boolean depthead;
		private boolean benco;
		
		//getters & setters
		public String getUsername()
			{
				return username;
			}
		public void setUsername(String username)
			{
				this.username = username;
			}
		public String getPassword()
			{
				return password;
			}
		public void setPassword(String password)
			{
				this.password = password;
			}
		public String getFirstname()
			{
				return firstname;
			}
		public void setFirstname(String firstname)
			{
				this.firstname = firstname;
			}
		public String getLastname()
			{
					return lastname;
			}
		public void setLastname(String lastname)
			{
					this.lastname = lastname;
			}
		public boolean isSupervisor()
			{
					return supervisor;
			}
		public void setSupervisor(boolean supervisor)
			{
					this.supervisor = supervisor;
			}
		public boolean isDepthead()
			{
					return depthead;
			}
		public void setDepthead(boolean depthead)
			{
					this.depthead = depthead;
			}
		public boolean isBenco()
			{
					return benco;
			}
		public void setBenco(boolean benco)
			{
					this.benco = benco;
			}

		@Override
		public String toString()
			{
				return "Employee [username=" + username + ", password=" + password + ", firstname="
						+ firstname + ", lastname=" + lastname + ", supervisor=" + supervisor
						+ ", depthead=" + depthead + ", benco=" + benco + "]";
			}

		@Override
		public int hashCode()
			{
				final int prime = 31;
				int result = 1;
				result = prime * result + (benco ? 1231 : 1237);
				result = prime * result + (depthead ? 1231 : 1237);
				result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
				result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
				result = prime * result + ((password == null) ? 0 : password.hashCode());
				result = prime * result + (supervisor ? 1231 : 1237);
				result = prime * result + ((username == null) ? 0 : username.hashCode());
				return result;
			}

		@Override
		public boolean equals(Object obj)
			{
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Employee other = (Employee) obj;
				if (benco != other.benco)
					return false;
				if (depthead != other.depthead)
					return false;
				if (firstname == null)
					{
						if (other.firstname != null)
							return false;
					} else if (!firstname.equals(other.firstname))
					return false;
				if (lastname == null)
					{
						if (other.lastname != null)
							return false;
					} else if (!lastname.equals(other.lastname))
					return false;
				if (password == null)
					{
						if (other.password != null)
							return false;
					} else if (!password.equals(other.password))
					return false;
				if (supervisor != other.supervisor)
					return false;
				if (username == null)
					{
						if (other.username != null)
							return false;
					} else if (!username.equals(other.username))
					return false;
				return true;
			}
		
		
		
		
	}
