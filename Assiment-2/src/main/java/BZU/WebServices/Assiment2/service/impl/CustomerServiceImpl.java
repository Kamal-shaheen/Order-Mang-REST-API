package BZU.WebServices.Assiment2.service.impl;
import BZU.WebServices.Assiment2.DTO.CustomerDto;
import BZU.WebServices.Assiment2.entity.Customer;
import BZU.WebServices.Assiment2.exception.ResourceNotFoundException;
import BZU.WebServices.Assiment2.repository.CustomerRepository;
import BZU.WebServices.Assiment2.service.CustomerService;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDto createCustomerRecords(CustomerDto customerDto) {
        Customer customer = mapToEntity(customerDto);
        Customer newCustomer = customerRepository.save(customer);
        CustomerDto customerDto1 = mapToDto(newCustomer);
        return customerDto1;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> list = customerRepository.findAll();
        return list.stream().map(customer -> mapToDto(customer)).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(long id) {
        Customer customer =  customerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Customer","Id",id)
        );
        return mapToDto(customer);
    }


    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, long id) {

        Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer","Id",id));

        customer.setDob(customerDto.getDob());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());

        Customer updateCustomer = customerRepository.save(customer);
        return mapToDto(updateCustomer);

    }

    @Override
    public void deleteCustomerById(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer","Id",id));
        customerRepository.delete(customer);

    }


    //Change From  Entity to DTO
    private CustomerDto mapToDto (Customer customer){

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setDob(customer.getDob());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        return customerDto;
    }
    //Change From  DTO to Entity
    private Customer mapToEntity (CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setDob(customerDto.getDob());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        return customer;
    }


}
