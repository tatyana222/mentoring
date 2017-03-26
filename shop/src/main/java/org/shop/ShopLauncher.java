package org.shop;


import org.shop.api.UserService;
import org.shop.repository.ItemRepository;
import org.shop.repository.ProductRepository;
import org.shop.repository.ProposalRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        System.out.println("Get bean by name:");
        ItemRepository itemRepository = (ItemRepository) context.getBean("itemRepository");
        System.out.println(itemRepository.toString());

        System.out.println("Get bean by type:");
        UserInitializer userInitializer = context.getBean(UserInitializer.class);
        System.out.println(userInitializer.toString());

        System.out.println("Get bean by name and type:");
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        System.out.println(productRepository.toString());

        System.out.println("Get bean by alias:");
        UserService customerService = (UserService) context.getBean("customerService");
        System.out.println(customerService.toString());
    }
}
