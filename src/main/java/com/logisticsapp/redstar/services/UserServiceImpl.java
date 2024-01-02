package com.logisticsapp.redstar.services;

import com.logisticsapp.redstar.data.models.Address;
import com.logisticsapp.redstar.data.models.Send;
import com.logisticsapp.redstar.data.models.User;
import com.logisticsapp.redstar.data.repositories.UserRepository;
import com.logisticsapp.redstar.dto.requests.RegisterRequest;
import com.logisticsapp.redstar.exceptions.InvalidDetailsException;
import com.logisticsapp.redstar.exceptions.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static com.logisticsapp.redstar.utils.Mapper.map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;
    @Autowired
    private SenderService senderService;
    @Autowired
    private ReceiverService receiverService;
    @Override
    public void register(RegisterRequest registerRequest) {
        if (userExist(registerRequest.getUsername())) throw new UserExistException(registerRequest.getUsername() + " already exist");
        User user = map(registerRequest);
        repository.save(user);
    }

    private boolean userExist(String username) {
        User foundUser = repository.findByUsername(username);
        return foundUser != null;

    }

    @Override
    public void login(String username, String password) {
        User foundUser = repository.findByUsername(username);
        if (!userExist(username)) throw new InvalidDetailsException();
        if(!foundUser.getPassword().equals(password)) throw new InvalidDetailsException();
        foundUser.setLoggedIn(true);
        repository.save(foundUser);
    }

    @Override
    public void sendGoods(String username, String receiverUsername, String phoneNumber, Address receiverAddress) {
        User findUser = repository.findByUsername(username);
        senderService.sendProduct( findUser.getId(), receiverUsername, phoneNumber, receiverAddress);
    }

    @Override
    public List<Send> findGoodsSentBelongingTo(String username) {
       User findGoods = repository.findByUsername(username);
       List<Send> goodsSent = new ArrayList<>();
       for (Send send: senderService.findAll()){
           if (send.getUserId().equals(findGoods.getId())) goodsSent.add(send);
       }
       return goodsSent;
    }

    @Override
    public void receiveGoods(String username) {
        User findUser = repository.findByUsername(username);
        receiverService.receiveGoods(findUser.getUserEmail());
    }


}
