package apap.tutorial.manpromanpro.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import apap.tutorial.manpromanpro.repository.RoleDb;
import apap.tutorial.manpromanpro.model.Role;

@Service
public class RoleRestServiceImpl implements RoleRestService{
    @Autowired
    private RoleDb roleDb;

    @Override
    public List<Role> getAllRoles(){
        return roleDb.findAll();
    }

    @Override
    public Role getRoleByRoleName(String name){
        return roleDb.findByRole(name).orElse(null);
    }
}
