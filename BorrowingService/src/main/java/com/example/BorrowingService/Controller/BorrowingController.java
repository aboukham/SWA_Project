package com.example.BorrowingService.Controller;

import com.example.BorrowingService.Domain.Borrowing;
import com.example.BorrowingService.Service.BorrowingService;
import com.example.BorrowingService.Service.Dto.BorrowingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrowing")
public class BorrowingController {
    @Autowired
    BorrowingService borrowingService;
    @GetMapping("/{borrowingNum}")
    public ResponseEntity<?> get(@PathVariable String borrowingNum){
        BorrowingDto borrowingDto = borrowingService.getBorrowing(borrowingNum);
        System.out.println("the customer is :" + borrowingDto);
        return new ResponseEntity<BorrowingDto>(borrowingDto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody BorrowingDto borrowingDto){
        borrowingService.addBorrowing(borrowingDto);
        System.out.println("the customer is added");
        return new ResponseEntity<BorrowingDto>(borrowingDto, HttpStatus.OK);
    }
    @PutMapping("/{customerNum}")
    public ResponseEntity<?> update(@PathVariable String borrowingNum, @RequestBody BorrowingDto borrowingDto){
        borrowingService.updateBorrowing(borrowingNum, borrowingDto);
        System.out.println("the customer is updated");
        return new ResponseEntity<BorrowingDto>(borrowingDto, HttpStatus.OK);
    }

    @DeleteMapping("/{customerNum}")
    public ResponseEntity<?> delete(@PathVariable String borrowingNum){
        borrowingService.deleteCustomer(borrowingNum);
        System.out.println("the customer is deleted");
        return new ResponseEntity<BorrowingDto>(HttpStatus.OK);
    }
}
