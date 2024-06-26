import { Routes } from '@angular/router';
import { CharactersTableComponent } from './characters-table/characters-table.component';
import { HistoryTableComponent } from './history-table/history-table.component';

export const routes: Routes = [
    { path: '', component: CharactersTableComponent },
    { path: 'characters', component: CharactersTableComponent },
    { path: 'history', component: HistoryTableComponent }
  ];