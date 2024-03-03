import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { PerformanceService } from '../../services/performance.service';
import { Performance } from '../../model/performance';

@Component({
  selector: 'app-performance-add-modal',
  templateUrl: './performance-add-modal.component.html',
  styleUrls: ['./performance-add-modal.component.css']
})
export class PerformanceAddModalComponent implements OnInit {
  performance: Performance = new Performance(); // Performance object to be added or updated

  constructor(
    public dialogRef: MatDialogRef<PerformanceAddModalComponent>,
    private performanceService: PerformanceService,
    @Inject(MAT_DIALOG_DATA) public data: any // Inject data from parent component
  ) { }

  ngOnInit(): void {  
    if (this.data.mode === 'update') {
      // If mode is update, set performance object to the one passed from parent component
      this.performance = { ...this.data.performance };
    }
  }

  submitPerformance(): void {
    if (this.data.mode === 'add') {
     
      // If mode is add, add the performance
      console.log(this.performance.timeout);
      this.performanceService.addPerformance(this.performance)
        .subscribe((newPerformance) => {
          console.log('Performance added:', newPerformance.id);
          this.dialogRef.close(newPerformance); // Close modal and pass new performance
        });
    } else if (this.data.mode === 'update') {
      // If mode is update, update the performance
      this.performanceService.updatePerformance(this.performance)
        .subscribe(() => {
       
        
          this.dialogRef.close(this.performance); // Close modal and pass updated performance
          // onceden updatedPerformance yazıyordu burada degistirdin incele
          // buradaki olay verinin sunucunan geldigi hali mi mevzusu bakıp burayı da guncelleyebilirsin.
          // ama zaten update oldugu icin id ayni sorun cikarmiyor simdilik.
        });
    }
  }
  
}
