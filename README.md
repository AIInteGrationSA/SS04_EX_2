# SS04 - EX2: Thiet ke DTO boc tach phong thu

## Lua chon toi uu

Nen chon phuong an 2: LLM boc tach vao Java Record DTO `IncidentExtraction`, sau do validate va mapping sang JPA Entity `IncidentReport`.

## So sanh hai phuong an

### Phuong an 1: Boc tach truc tiep vao JPA Entity

Uu diem:

- It class hon, code demo ngan hon.
- Co the save truc tiep sau khi converter tra ve object.

Nhuoc diem:

- Pha vo dong goi: entity vua la mo hinh persistence, vua la contract nhan du lieu tu AI.
- LLM co the tao gia tri cho cac truong khong nen cho phep ghi, vi du `id`, `createdAt`, `status`.
- Hibernate can constructor mac dinh va field mutable; dieu nay khong hop voi du lieu AI khong tin cay.
- Entity co rang buoc DB nhu `nullable=false`, ID auto-generated, enum, quan he lazy. Neu LLM tra null/rac, loi se no o tang DB thay vi tang nghiep vu.
- Kho kiem soat invariant: object co the ton tai o trang thai nua dung nua sai truoc khi flush transaction.

### Phuong an 2: DTO trung gian roi mapping sang Entity

Uu diem:

- Record DTO bat bien, ro rang la du lieu thô tu AI.
- Tach input contract khoi persistence model.
- Co mot diem validate phong thu truoc khi cham vao entity va database.
- Entity giu duoc invariant: ID do DB sinh, field bat buoc chi duoc set sau validate.
- De log, audit, reject, retry khi AI tra du lieu thieu.

Nhuoc diem:

- Them mot lop DTO va mapping.
- Can viet validation thu cong, nhung day la chi phi can thiet khi xu ly output cua LLM.

## Ket luan phong thu

Entity JPA la bien gioi cua database, khong nen la bien gioi cua AI. Output cua LLM phai duoc xem nhu input ben ngoai: co the sai schema, thieu field, sai enum, hoac tao field ngoai mong doi. DTO trung gian giup he thong co vung dem an toan truoc khi du lieu duoc dua vao Hibernate.

## Source chinh

- `src/main/java/com/rikkei/logistics/incident/IncidentExtraction.java`
- `src/main/java/com/rikkei/logistics/incident/IncidentReport.java`

## Cach chay

```powershell
$gradle="C:\Users\Lochuynh\.gradle\wrapper\dists\gradle-8.7-bin\bhs2wmbdwecv87pi65oeuq5iu\gradle-8.7\bin\gradle.bat"
& $gradle bootRun
```

## Minh chung log console

```text
Started DefensiveDtoApplication
SS04_EX2 JPA entity saved successfully id=1, orderCode=ORD-SS04-0001, licensePlate=51C-12345, urgency=HIGH
```

## GitHub

Tao repository rieng cho bai nay va day thu muc `SS04/EX_2` len GitHub. Link nop bai:

```text
https://github.com/<your-user>/ss04-ex2-defensive-dto
```
