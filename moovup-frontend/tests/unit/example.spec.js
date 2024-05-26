import { mount, shallowMount } from '@vue/test-utils'
import People from '@/views/People.vue'

// describe("People.vue", () => {
//   it("renders msg text", () => {
//     const wrapper = mount(People);
//     console.log(wrapper.html())
//     // expect(wrapper.text()).toBe("new message");
//   });
// });

// const App = {
//   template: `
//     <div>Hello</div>
//   `
// }

// const app = People

// test('App', () => {
//   const wrapper = mount(app)
//   console.log(wrapper)
//   // expect(wrapper.html()).toContain('<div>Hello</div>')
// })


describe("Test to do list", () => {
  it("Test to do 1", () => {
    expect(1 + 1).toBe(2);
  });
  test("Test to do 2", () => {
   expect(2 + 1).toBe(3);
  });
});