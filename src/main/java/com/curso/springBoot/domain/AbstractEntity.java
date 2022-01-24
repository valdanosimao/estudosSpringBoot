package com.curso.springBoot.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass //dizer a jpa que é uma super classe das identidades
public abstract class AbstractEntity <ID extends Serializable> implements Serializable {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private ID id;

		public ID getId() {
			return id;
		}		

		public void setId(ID id) {
			this.id = id;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			@SuppressWarnings("rawtypes")
			AbstractEntity other = (AbstractEntity) obj;
			return Objects.equals(id, other.id);
		}

		@Override
		public String toString() {
			return "id=" + id;
		}
		
		
		
}
