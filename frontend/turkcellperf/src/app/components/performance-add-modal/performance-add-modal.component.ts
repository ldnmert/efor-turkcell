import { Component, Inject } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { PerformanceService } from '../../services/performance.service';
import { Performance } from '../../model/performance';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-performance-add-modal',
  templateUrl: './performance-add-modal.component.html',
  styleUrl: './performance-add-modal.component.css'
})
export class PerformanceAddModalComponent {
    newPerformance: Performance = new Performance(); // Yeni performans nesnesi

    constructor(
      public dialogRef: MatDialogRef<PerformanceAddModalComponent>,
      private performanceService: PerformanceService
    ) { }

    addPerformance(): void {
      this.performanceService.addPerformance(this.newPerformance)
        .subscribe(newPerformance => {
          console.log('Performans eklendi:', newPerformance);
          this.dialogRef.close(newPerformance); // Modalı kapat ve sonucu gönder
        });


      
  }
}

