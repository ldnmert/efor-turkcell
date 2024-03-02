import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { PerformanceService } from '../../services/performance.service';
import { Performance } from '../../model/performance';
import { MatDialog } from '@angular/material/dialog';
import { PerformanceAddModalComponent } from '../performance-add-modal/performance-add-modal.component';

@Component({
  selector: 'app-performance-table',
  templateUrl: './performance-table.component.html',
  styleUrls: ['./performance-table.component.css']
})
export class PerformanceTableComponent implements OnInit {
  performances: Performance[] = [];

  constructor(private performanceService: PerformanceService, private changeDetector: ChangeDetectorRef, public dialog: MatDialog) { }
  
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
    console.log("component.ts");
    this.performanceService.deletePerformance(id)
      .subscribe(() => {
        
        this.performances = this.performances.filter(performance => performance.id !== id);
      
      });


    }
  onClick() {
    console.log('Button clicked!');
   
  }

  // updatePerformance(updatedPerformance: Performance): void {
  //   this.performanceService.updatePerformance(updatedPerformance)
  //     .subscribe(() => {
  //       // If the update is successful, you may want to refresh the data.
  //       this.getPerformances();
  //     });
  // }

  // addPerformance(): void {
  //   this.performanceService.addPerformance(this.newPerformance)
  //     .subscribe(newPerformance => {
  //       this.performances.push(new Performance(
  //         newPerformance.id,
  //         newPerformance.agentId,
  //         newPerformance.firstName,
  //         newPerformance.surname,
  //         newPerformance.begin,
  //         newPerformance.end,
  //         newPerformance.dateInfo,
  //         newPerformance.execuse,
  //         newPerformance.execuseHours,
  //         newPerformance.timeout
  //       ));
  //       this.newPerformance = new Performance(0, '', '', '', '', '', '', '', 0, 0); // Formu temizle
  //     });
  // }

  openAddPerformanceModal(): void {
    const dialogRef = this.dialog.open(PerformanceAddModalComponent, {
      width: '400px' // Modal pencerenin genişliği
    });
  
    dialogRef.afterClosed().subscribe(newPerformance => {
      if (newPerformance) {
        this.performances.push(newPerformance);
      }
    });
  }

 
  }
