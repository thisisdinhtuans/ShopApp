package com.project.shopapp.services;

import com.project.shopapp.dtos.OrderDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.models.Order;
import com.project.shopapp.models.OrderStatus;
import com.project.shopapp.models.User;
import com.project.shopapp.repositories.OrderRepository;
import com.project.shopapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
//    @Override
//    public Order createOrder(OrderDTO orderDTO) throws Exception {
//        //tìm user id có tồn tại không
//        User user = userRepository.findById(orderDTO.getUserId()).orElseThrow(()->new DataNotFoundException("Cannot find user with id"+orderDTO.getUserId()));
//        //convert orderDTO sang Order để lưu vào database
//        //dùng thư viện Model Mappper
//        //Tạo 1 luồng bảng ánh xạ riêng để kieerm soát việc ánh xạ
//        modelMapper.typeMap(OrderDTO.class, Order.class)
//                .addMappings(mapper->mapper.skip(Order::setId));
//        //Cập nhật các trường của đơn hàng từ OrderDTO
//        Order order=new Order();
//        modelMapper.map(orderDTO,order);
//        order.setUser(user);
//        order.setOrderDate(new Date()); //lấy thời điểm hiện tại
//        order.setStatus(OrderStatus.PENDING);
//        //kim tra shipping date phải >= ngay hôm nay
//        LocalDate shippingDate=orderDTO.getShippingDate() == null ? LocalDate.now():orderDTO.getShippingDate();
//        if(shippingDate.isBefore(LocalDate.now())){
//            throw new DataNotFoundException("Date must be at least today!");
//        }
//        order.setShippingDate(shippingDate);
//        //Active =false là xóa đơn hàng đi(xóa mềm)
//        order.setActive(true);
//        orderRepository.save(order);
//        return order;
//    }
@Override
public Order createOrder(OrderDTO orderDTO) throws Exception {
    //tìm xem user'id có tồn tại ko
    System.out.println("Received orderDTO: " + orderDTO.getUserId());
    Long userId=orderDTO.getUserId();
//    User user = userRepository
//            .findById(orderDTO.getUserId())
//            .orElseThrow(() -> new Exception("Cannot find user with id: "));
    User user=userRepository.findById(userId)
            .orElseThrow(()-> new RuntimeException("User not found"));
    //convert orderDTO => Order
    //dùng thư viện Model Mapper
    // Tạo một luồng bảng ánh xạ riêng để kiểm soát việc ánh xạ
    modelMapper.typeMap(OrderDTO.class, Order.class)
            .addMappings(mapper -> mapper.skip(Order::setId));
    // Cập nhật các trường của đơn hàng từ orderDTO
    Order order = new Order();
    modelMapper.map(orderDTO, order);
    order.setUser(user);
    order.setOrderDate(new Date());//lấy thời điểm hiện tại
    order.setStatus(OrderStatus.PENDING);
    //Kiểm tra shipping date phải >= ngày hôm nay
    LocalDate shippingDate = orderDTO.getShippingDate() == null
            ? LocalDate.now() : orderDTO.getShippingDate();
    if (shippingDate.isBefore(LocalDate.now())) {
        throw new DataNotFoundException("Date must be at least today !");
    }
    order.setShippingDate(shippingDate);
    order.setActive(true);
    orderRepository.save(order);
    return order;
}

    @Override
    public Order getOrder(Long id) {
        return null;
    }

    @Override
    public Order updateOrder(Long id, OrderDTO orderDTO) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {

    }

    @Override
    public List<Order> getAllOrders(Long userId) {
        return List.of();
    }
}
