import tkinter as tk
from tkinter import messagebox, simpledialog
import requests
import threading

class ItemCRUDApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Item CRUD App")

        # Create GUI elements
        self.label_title = tk.Label(root, text="Title:")
        self.entry_title = tk.Entry(root)

        self.label_images = tk.Label(root, text="Images:")
        self.entry_images = tk.Entry(root)

        self.label_prices = tk.Label(root, text="Prices:")
        self.entry_prices = tk.Entry(root)

        self.button_show_all = tk.Button(root, text="Show All Items", command=self.show_all_items)
        self.button_create = tk.Button(root, text="Create Item", command=self.create_item)
        self.button_update = tk.Button(root, text="Update Item", command=self.update_item)
        self.button_delete = tk.Button(root, text="Delete Item", command=self.delete_item)

        # Layout
        self.label_title.grid(row=0, column=0, padx=10, pady=5, sticky="e")
        self.entry_title.grid(row=0, column=1, padx=10, pady=5)

        self.label_images.grid(row=1, column=0, padx=10, pady=5, sticky="e")
        self.entry_images.grid(row=1, column=1, padx=10, pady=5)

        self.label_prices.grid(row=2, column=0, padx=10, pady=5, sticky="e")
        self.entry_prices.grid(row=2, column=1, padx=10, pady=5)

        self.button_show_all.grid(row=3, column=0, columnspan=2, pady=10)
        self.button_create.grid(row=4, column=0, columnspan=2, pady=5)
        self.button_update.grid(row=5, column=0, columnspan=2, pady=5)
        self.button_delete.grid(row=6, column=0, columnspan=2, pady=5)

    def show_all_items(self):
        threading.Thread(target=self._show_all_items).start()

    def _show_all_items(self):
        try:
            response = requests.get("http://localhost:7000/api/items")
            response.raise_for_status()
            items = response.json()
            self.root.after(0, lambda e=None: messagebox.showinfo("Items", "\n".join([f"{item['id']}: {item['title']}" for item in items])))
        except requests.exceptions.RequestException as e:
            self.root.after(0, lambda e=e: messagebox.showerror("Error", f"Failed to fetch items. {e}"))

    def create_item(self):
        threading.Thread(target=self._create_item).start()

    def _create_item(self):
        try:
            title = self.entry_title.get()
            images = self.entry_images.get()
            prices = float(self.entry_prices.get())

            new_item = {"title": title, "images": images, "prices": prices}
            response = requests.post("http://localhost:7000/api/items", json=new_item)
            response.raise_for_status()

            self.root.after(0, lambda e=None: messagebox.showinfo("Success", "Item created successfully."))
        except requests.exceptions.RequestException as e:
            self.root.after(0, lambda e=e: messagebox.showerror("Error", f"Failed to create item. {e}"))

    def update_item(self):
        threading.Thread(target=self._update_item).start()

    def _update_item(self):
        try:
            # Assume the ID is entered manually for updating
            item_id = simpledialog.askinteger("Input", "Enter Item ID:")
            if item_id is None:
                return

            title = self.entry_title.get()
            images = self.entry_images.get()
            prices = float(self.entry_prices.get())

            updated_item = {"title": title, "images": images, "prices": prices}
            response = requests.put(f"http://localhost:7000/api/items/{item_id}", json=updated_item)
            response.raise_for_status()

            self.root.after(0, lambda e=None: messagebox.showinfo("Success", "Item updated successfully."))
        except requests.exceptions.RequestException as e:
            self.root.after(0, lambda e=e: messagebox.showerror("Error", f"Failed to update item. {e}"))

    def delete_item(self):
        threading.Thread(target=self._delete_item).start()

    def _delete_item(self):
        try:
            # Assume the ID is entered manually for deletion
            item_id = simpledialog.askinteger("Input", "Enter Item ID:")
            if item_id is None:
                return

            response = requests.delete(f"http://localhost:7000/api/items/{item_id}")
            response.raise_for_status()

            self.root.after(0, lambda e=None: messagebox.showinfo("Success", "Item deleted successfully."))
        except requests.exceptions.RequestException as e:
            self.root.after(0, lambda e=e: messagebox.showerror("Error", f"Failed to delete item. {e}"))

if __name__ == "__main__":
    root = tk.Tk()
    app = ItemCRUDApp(root)
    root.mainloop()
