CREATE PROCEDURE top10Product (
StartDate date,
EndDate date
)
BEGIN
	select  DISTINCT
    Name ten, sum(ords.Quantity) sl
    from orders ors inner join orderdetails ords on ords.IDOrder = ords.IDOrder
    inner join products pro on pro.IDProduct = ords.IDProduct
    
    where CAST(StartDate as date) <= CAST(ors.OrderDate as date) 
    and CAST(EndDate as date) >= CAST(ors.OrderDate as date)
    and ors.OrderState = 2
    group by pro.Name, ords.Quantity
    order by pro.Name, ords.Quantity
    limit 10
    ;
    
END