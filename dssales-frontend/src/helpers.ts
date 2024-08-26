import { SalesByPaymentMethod, SalesByStore } from './types';

export const buildSalesByStoreChart = (sales: SalesByStore[]) => {
  const labels = sales.map((sale) => sale.storeName);
  const series = sales.map((sale) => sale.sum);

  return {
    labels,
    series
  };
};

export const buildSalesByPaymentMethod = (sales: SalesByPaymentMethod[]) => {
  const labels = sales.map((sale) => sale.description);
  const series = sales.map((sale) => sale.sum);

  return {
    labels,
    series
  };
};
