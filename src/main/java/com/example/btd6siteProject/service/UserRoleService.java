package com.example.btd6siteProject.service;

import com.example.btd6siteProject.model.entity.AppUser;
import com.example.btd6siteProject.model.entity.Role;
import com.example.btd6siteProject.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public List<Role> addRolesToUser(AppUser user){
        Role role = new Role();
        int id = user.getId();
        role.setId(id);
        role.setName("USER");

        roleRepository.save(role);

        List<Role> roles = new ArrayList<>();
        roles.add(role);
        return roles;
    }
}
