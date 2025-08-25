package com.FirstProject.Store.services;
import org.springframework.security.core.userdetails.*;
import ch.qos.logback.core.net.SyslogOutputStream;
import com.FirstProject.Store.entities.Category;
import com.FirstProject.Store.entities.Product;
import com.FirstProject.Store.entities.User;
import com.FirstProject.Store.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Collections;


@AllArgsConstructor
@Service
public class UserService  {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final ProductRepository productRepository;
    private final AddressRepository addressRepository;
    private final CategoryRepository categoryRepository;



    private final EntityManager entityManager;
    @Transactional
    public  void showEntityState(){
        var user = User.builder()
                .name("mahesh")
                .email("mahesh@gmail.com")
                .password("123456")
                .build();
        if(entityManager.contains(user)){
            System.out.println("Persistant");
        }
        else {System.out.println("Transient / detached");}
        userRepository.save(user);
        if(entityManager.contains(user)){
            System.out.println("Persistant");
        }
        else {System.out.println("Transient / detached");}
    }

    @Transactional
    public void showRelatedEntities(){
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getCity());
    }

    @Transactional
    public void manageProduct(){

      productRepository.deleteById(3L);
    }


}
