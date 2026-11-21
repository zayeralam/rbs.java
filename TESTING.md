# Test Report — SERVEDESK

The following 14 cases were executed against the current console program using scripted console inputs. Each case was checked against the expected output.

| Test | Action | Expected result | Result |
|---|---|---|---|
| 1 | Display Menu | Menu codes and prices shown | PASS |
| 2 | Place code 101 with quantity 2 | Order accepts quantity | PASS |
| 3 | Add code 101 again with quantity 1 | Quantity combines to 3 | PASS |
| 4 | View Current Order after tests 2 and 3 | Quantity 3 and Rs. 360.00 shown | PASS |
| 5 | Enter an unknown code | Invalid code message shown | PASS |
| 6 | Enter zero and negative quantities | Rejects quantity | PASS |
| 7 | Enter letters at numeric prompt | Re-prompts for a whole number | PASS |
| 8 | View order with no selections | Says order is empty | PASS |
| 9 | Generate bill with no selections | Says no order to bill | PASS |
| 10 | Clear order and choose No | Keeps current order | PASS |
| 11 | Clear order and choose Yes | Resets quantities | PASS |
| 12 | Generate bill for an order | Prints total and clears order | PASS |
| 13 | Enter menu choice outside 1–6 | Shows invalid menu choice | PASS |
| 14 | Enter 6 | Exits program | PASS |

## How to run the program

```bash
javac RestaurantBillingSystem.java
java RestaurantBillingSystem
```

## Scope

These checks cover the listed console behaviours. They are not a formal unit-test suite and do not establish testing of every possible input or environment.
