package alikagan.northwind.business;

import alikagan.northwind.core.results.DataResult;
import alikagan.northwind.core.results.Result;
import alikagan.northwind.core.results.SuccessDataResult;
import alikagan.northwind.core.results.SuccessResult;
import alikagan.northwind.entity.User;
import alikagan.northwind.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Result add(User user) {
        this.userRepository.save(user);
        return new SuccessResult("User succesfully added");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userRepository.findByEmail(email),"User found succesfully");
    }
}
