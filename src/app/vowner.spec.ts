import { Vowner } from './vowner';
import { TestBed } from '@angular/core/testing';
import { VownerService } from './vowner.service';


describe('VownerService', () => {

  let service: VownerService;

    beforeEach(()=>{
        TestBed.configureTestingModule({});
        service=TestBed.inject(VownerService);
    });

    it('should be created',()=>{
        expect(service).toBeTruthy();
    })
});
