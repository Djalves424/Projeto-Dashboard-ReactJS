export type Gender = 'MALE' | 'FEMALE' | 'OTHER';

export type SalesByDate = {
  date: string;
  sum: number;
};

export type ChartSeriesData = {
  x: string;
  y: number;
};

export type FilterData = {
  dates?: Date[];
  gender?: Gender;
};
