# Manual Test Checklist

Run the program and verify each case:

| Test | Action | Expected result |
|---|---|---|
| 1 | Choose Display Menu | Menu codes and prices are shown |
| 2 | Place code 101 with quantity 2 | Order accepts quantity |
| 3 | Add code 101 again with quantity 1 | Quantity combines to 3 |
| 4 | View Current Order | Shows quantity 3 and amount Rs. 360.00 |
| 5 | Enter an unknown code | Displays invalid code message |
| 6 | Enter quantity 0 or a negative value | Rejects quantity |
| 7 | Enter letters when numeric input is requested | Prompts for a whole number again |
| 8 | View order with no selections | Says order is empty |
| 9 | Generate bill with no selections | Says no order to bill |
| 10 | Clear order and choose No | Keeps current order |
| 11 | Clear order and choose Yes | Resets quantities |
| 12 | Generate bill for an order | Prints total and clears order |
| 13 | Enter menu choice outside 1–6 | Shows invalid menu choice |
| 14 | Enter 6 | Exits program |

This is a manual test plan; each case should be run and checked before claiming all tests passed.
