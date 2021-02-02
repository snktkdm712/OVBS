import { AdminService } from "./admin.service"
import { TestBed } from '@angular/core/testing';


describe('AdminService',()=>{
    let service: AdminService;

    beforeEach(()=>{
        TestBed.configureTestingModule({});
        service=TestBed.inject(AdminService);
    });

    it('should be created',()=>{
        expect(service).toBeTruthy();
    })
})