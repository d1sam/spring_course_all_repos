package org.example;

import org.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {// с помощью объекта этого класса и его методов можно общаться с рест сервисом
    // то есть осуществляться http запросы и получать ответы
    @Autowired
    private RestTemplate restTemplate;// данный объект осуществляет http запросы
    private final String URL = "http://localhost:8080/com_dmitryshulga_mvc_rest_war_exploded/api/employees";// url на наш rest сервис

    public List<Employee> getAllEmployees() {
        // ResponseEntity - обертка http response, в дженерике тот тип, который будет содержаться в теле response
        ResponseEntity<List<Employee>> responseEntity =
                // первый параметр - url, по котором реквест
                // второй параметр - какой именно http метод уйдет в запросе
                // третий параметр - requestEntity, используют когда хотят добавить тело к запросу
                // четвертый параметр - вспомагательный класс, целью которого является передача дженерик типа
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
                });
        // из ResponseEntity получаем PayLoad (полезную нагрузку), то есть тело http ответа (список всех работников)
        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }

    public Employee getEmployee(int id) {
        return restTemplate.getForObject(URL + "/" + id, Employee.class);// к урле добавляем слеш и айди объекта, который нужно получить
        // вторым параметром является класс объекта, который хотим получить
    }

    public void saveEmployee(Employee employee) {
        int id = employee.getId();// получаем айди объекта
        if (id == 0) {// если айди = 0, то мы будем создавать объект в бд, а значит постить его
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            // дженериком является стринг, так как ответом будет джсон, который преобразуется в стринг
            // первым параметром является урла по которой осуществляется запрос
            // вторым параметром является объект, который будет помещен в тело запроса
            // третьим параметром является класс объекта, который хотим получить в ответе
            System.out.println("New employee was added to DB!");
            // получаем из ответа тело
            System.out.println(responseEntity.getBody());
        } else {// если не ноль, то мы изменяем уже существующий объект из бд
            restTemplate.put(URL, employee);// первый параметр - урла, по которой запрос, а второй объект, который будет помещен в тело запроса
            System.out.println("Employee with ID = " + id + " was updated!");
        }
    }

    public void deleteEmployee(int id) {
        restTemplate.delete(URL + "/" + id);// делаем delete http запрос с помощью урл 
        System.out.println("Employee with ID = " + id + " was deleted from DB!");
    }
}
