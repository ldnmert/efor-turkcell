import { ChangeDetectionStrategy, ChangeDetectorRef, Component, NgZone, OnInit } from '@angular/core';
import { PerformanceService } from '../../services/performance.service';
import { Performance } from '../../model/performance';
import { MatDialog } from '@angular/material/dialog';
import { PerformanceAddModalComponent } from '../performance-add-modal/performance-add-modal.component';

@Component({
  selector: 'app-performance-table',
  templateUrl: './performance-table.component.html',
  styleUrls: ['./performance-table.component.css'],
  // changeDetection: ChangeDetectionStrategy.OnPush

})
export class PerformanceTableComponent implements OnInit {
  performances: Performance[] = [];

  constructor(private performanceService: PerformanceService, public dialog: MatDialog) { }
  
  newPerformance: Performance = new Performance(0, '', '', '', '', '', '', '', 0, 0); 
  ngOnInit(): void {
    
    
    this.getPerformances();


   
  }

  getPerformances(): void {
    console.log("meee");
    this.performanceService.getPerformances()
      .subscribe(performances => this.performances = performances);
  }

  deletePerformance(id: number): void { 
    console.log(id + "deleteFperfomancertablecomponent");
    console.log("component.ts");
    this.performanceService.deletePerformance(id)
      .subscribe(() => {
        
        this.performances = this.performances.filter(performance => performance.id !== id);
      
      });


    }


 

  openAddPerformanceModal(): void {
    const dialogRef = this.dialog.open(PerformanceAddModalComponent, {
      width: '400px', 
      data: { mode: 'add' } 
    });
  
    dialogRef.afterClosed().subscribe(newPerformance => {
      if (newPerformance) {
        this.performances.push(newPerformance);
      }
    });
  }

  openUpdatePerformanceModal(performance: Performance): void {
    const dialogRef = this.dialog.open(PerformanceAddModalComponent, {
      width: '400px',
      data: { mode: 'update', performance: performance }
    });
  
    dialogRef.afterClosed().subscribe(updatedPerformance => {
      console.log(updatedPerformance.begin);
      if (updatedPerformance) {
        const index = this.performances.findIndex(p => p.id === updatedPerformance.id);
     
          this.performances[index] = updatedPerformance;
        
          
            
          
        
      }
    });
  
  }

  
 
 
  }
