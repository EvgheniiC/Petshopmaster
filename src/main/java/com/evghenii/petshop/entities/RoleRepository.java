package com.eventim.petshop.entities;

import javax.ejb.Stateful;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Objects;

@Stateful
public class RoleRepository extends AbstractRepository {


    public Role createRole(String name) {
        Role role = new Role();
        role.setRollName(name);
        entityManager.persist(role);
        return role;
    }


    public List findAll() {
        return entityManager.createQuery(
                "SELECT c FROM Role c").getResultList();
    }


    public Role findOne(String roleName) throws EntityNotFoundException {
        Role role = find(Role.class, "Role.findByRole", roleName);
        if (Objects.isNull(role)) {
            throw new EntityNotFoundException("Could not find role with specified name " + roleName);
        }
        return role;
    }

    public Role getCustomerRole() throws Exception {
        try {
            Role role = findOne("user");
            System.out.println("Role nicht gefunden");
            return role;
        } catch (EntityNotFoundException e) {
            System.out.println("EntityNotFoundException ");
            return createRole("user");
        }
    }

    public Role getAdminRole() {
        try {
            Role role = findOne("admin");
            return role;
        } catch (EntityNotFoundException e) {
            return createRole("admin");
        }
    }
}
