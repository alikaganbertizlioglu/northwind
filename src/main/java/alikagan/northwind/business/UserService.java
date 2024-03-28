package alikagan.northwind.business;

import alikagan.northwind.core.results.DataResult;
import alikagan.northwind.core.results.Result;
import alikagan.northwind.entity.User;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}
